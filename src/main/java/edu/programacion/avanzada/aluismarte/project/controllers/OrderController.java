package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.aluismarte.project.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aluis on 7/10/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<GetOrderResponse> get() {
        return ResponseEntity.ok(GetOrderResponse.builder()
                .orders(orderService.getAll())
                .build());
    }
}
