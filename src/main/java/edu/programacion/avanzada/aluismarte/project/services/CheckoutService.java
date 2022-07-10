package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.domain.*;
import edu.programacion.avanzada.aluismarte.project.model.dto.CheckoutDTO;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.AddProductCheckoutRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.repositories.AddressRepository;
import edu.programacion.avanzada.aluismarte.project.repositories.CheckoutRepository;
import edu.programacion.avanzada.aluismarte.project.repositories.PaymentMethodRepository;
import edu.programacion.avanzada.aluismarte.project.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    public List<CheckoutDTO> getAll() {
        return checkoutRepository.findAll().stream().map(Checkout::toDTO).collect(Collectors.toList());
    }

    public CheckoutDTO get(UUID id) {
        return checkoutRepository.findById(id).orElseThrow().toDTO();
    }

    public CheckoutDTO updatePaymentMethod(CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        Checkout checkout = checkoutRepository.findById(checkoutUpdatePaymentMethodRequest.getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(checkoutUpdatePaymentMethodRequest.getPaymentMethod()).orElseThrow();
        checkout.setPaymentMethod(paymentMethod);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }

    public CheckoutDTO updateAddress(CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        Checkout checkout = checkoutRepository.findById(checkoutUpdateAddressRequest.getId()).orElseThrow();
        Address address = addressRepository.findById(checkoutUpdateAddressRequest.getAddress()).orElseThrow();
        checkout.setAddress(address);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }

    public CheckoutDTO addProducts(AddProductCheckoutRequest addProductCheckoutRequest) {
        Checkout checkout = checkoutRepository.findById(addProductCheckoutRequest.getId()).orElseThrow();
        Product product = productRepository.findById(addProductCheckoutRequest.getProduct()).orElseThrow();
        List<CheckoutProduct> productsToBuy = checkout.getProductsToBuy();
        if (productsToBuy == null) {
            productsToBuy = new ArrayList<>();
        }
        // TODO si el producto no existe lo agrego
        // TODO si el producto existe, lo actualizo
        checkout.setProductsToBuy(productsToBuy);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }
}
