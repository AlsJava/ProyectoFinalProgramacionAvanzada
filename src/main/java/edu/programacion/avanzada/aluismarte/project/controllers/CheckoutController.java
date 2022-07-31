package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutAddProductRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.checkout.PayCheckoutRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.*;
import edu.programacion.avanzada.aluismarte.project.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<GetCheckoutResponse> get(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                   @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(checkoutService.getAll(pageSize, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCheckoutResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(checkoutService.get(id));
    }

    @PostMapping("/update/address")
    public ResponseEntity<CheckoutUpdateAddressResponse> updateAddress(@RequestBody CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        return ResponseEntity.ok(checkoutService.updateAddress(checkoutUpdateAddressRequest));
    }

    @PostMapping("/update/payment/method")
    public ResponseEntity<CheckoutUpdatePaymentMethodResponse> updatePaymentMethod(@RequestBody CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        return ResponseEntity.ok(checkoutService.updatePaymentMethod(checkoutUpdatePaymentMethodRequest));
    }

    @PostMapping("/add/product")
    public ResponseEntity<CheckoutAddProductResponse> addProduct(@RequestBody CheckoutAddProductRequest checkoutAddProductRequest) {
        return ResponseEntity.ok(checkoutService.addProducts(checkoutAddProductRequest));
    }

    @PostMapping("/pay")
    public ResponseEntity<PayCheckoutResponse> pay(@RequestBody PayCheckoutRequest payCheckoutRequest) {
        return ResponseEntity.ok(checkoutService.pay(payCheckoutRequest));
    }
}
