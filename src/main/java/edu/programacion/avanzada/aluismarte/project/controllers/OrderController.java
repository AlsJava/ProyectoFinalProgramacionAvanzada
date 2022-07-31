package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.aluismarte.project.services.OrderService;
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
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<GetOrderResponse> get(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                @RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok(orderService.getAll(pageSize, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.get(id));
    }
}
