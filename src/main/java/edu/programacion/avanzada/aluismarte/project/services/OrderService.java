package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.command.order.GetAllOrderCommand;
import edu.programacion.avanzada.aluismarte.project.command.order.GetOrderCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final CommandBus commandBus;

    public GetOrderResponse getAll(Integer pageSize, Integer page) {
        return commandBus.sendCommand(GetAllOrderCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .build());
    }

    public GetOrderResponse get(UUID id) {
        return commandBus.sendCommand(GetOrderCommand.builder()
                .id(id)
                .build());
    }
}
