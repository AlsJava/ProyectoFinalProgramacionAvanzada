package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.request.payment.CreatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.payment.DeletePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.DeletePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetPaymentMethodResponse> get() {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(paymentMethodService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMethodResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(List.of(paymentMethodService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMethodResponse> create(@RequestBody CreatePaymentMethodRequest createPaymentMethodRequest) {
        return ResponseEntity.ok(CreatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.create(createPaymentMethodRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return ResponseEntity.ok(UpdatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.update(updatePaymentMethodRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMethodResponse> delete(@RequestBody DeletePaymentMethodRequest deleteEmployeeRequest) {
        paymentMethodService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeletePaymentMethodResponse.builder().build());
    }
}
