package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.domain.*;
import edu.programacion.avanzada.aluismarte.project.model.dto.CheckoutDTO;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutAddProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.PayCheckoutRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandBus;
import edu.programacion.avanzada.aluismarte.project.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    private final CommandBus commandBus;

    private final CheckoutRepository checkoutRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CheckoutProductRepository checkoutProductRepository;

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

    @Transactional
    public CheckoutDTO addProducts(CheckoutAddProductRequest checkoutAddProductRequest) {
        Checkout checkout = checkoutRepository.findById(checkoutAddProductRequest.getId()).orElseThrow();
        Product product = productRepository.findById(checkoutAddProductRequest.getProduct()).orElseThrow();
        if (checkoutAddProductRequest.getQuantity() > product.getAvailableQuantity()) {
            throw new RuntimeException("Available product if less than you need");
        }
        List<CheckoutProduct> productsToBuy = checkout.getProductsToBuy();
        if (productsToBuy == null) {
            productsToBuy = new ArrayList<>();
        }
        CheckoutProduct checkoutProduct = findProductInCheckout(productsToBuy, product.getId());
        if (checkoutProduct == null) {
            checkoutProduct = CheckoutProduct.builder()
                    .product(product)
                    .quantity(checkoutAddProductRequest.getQuantity())
                    .build();
            checkoutProductRepository.save(checkoutProduct);
            productsToBuy.add(checkoutProduct);
        } else {
            checkoutProduct.setQuantity(checkoutProduct.getQuantity() + checkoutAddProductRequest.getQuantity());
            checkoutProductRepository.save(checkoutProduct);
        }
        product.setAvailableQuantity(product.getAvailableQuantity() - checkoutAddProductRequest.getQuantity());
        productRepository.save(product);
        checkout.setProductsToBuy(productsToBuy);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }

    public PayCheckoutResponse pay(PayCheckoutRequest payCheckoutRequest) {
        return commandBus.sendCommand(payCheckoutRequest.toCommand());
    }

    private CheckoutProduct findProductInCheckout(List<CheckoutProduct> productsToBuy, Long productId) {
        for (CheckoutProduct checkoutProduct : productsToBuy) {
            if (checkoutProduct.getProduct().getId().equals(productId)) {
                return checkoutProduct;
            }
        }
        return null;
    }
}
