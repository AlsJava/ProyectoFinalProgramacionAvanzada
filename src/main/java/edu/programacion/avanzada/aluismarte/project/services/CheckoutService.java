package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.command.checkout.GetAllCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.command.checkout.GetCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutAddProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.PayCheckoutRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.*;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CommandBus commandBus;

    public GetCheckoutResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllCheckoutCommand.builder().pageSize(pageSize).page(page).build());
    }

    public GetCheckoutResponse get(UUID id) {
        return commandBus.sendCommand(GetCheckoutCommand.builder().id(id).build());
    }

    public CheckoutUpdatePaymentMethodResponse updatePaymentMethod(CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        return commandBus.sendCommand(checkoutUpdatePaymentMethodRequest.toCommand());
    }

    public CheckoutUpdateAddressResponse updateAddress(CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        return commandBus.sendCommand(checkoutUpdateAddressRequest.toCommand());
    }

    public CheckoutAddProductResponse addProducts(CheckoutAddProductRequest checkoutAddProductRequest) {
        return commandBus.sendCommand(checkoutAddProductRequest.toCommand());
    }

    public PayCheckoutResponse pay(PayCheckoutRequest payCheckoutRequest) {
        return commandBus.sendCommand(payCheckoutRequest.toCommand());
    }
}
