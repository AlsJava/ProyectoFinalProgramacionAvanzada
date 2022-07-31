package edu.programacion.avanzada.aluismarte.project.command.handler.order;

import edu.programacion.avanzada.aluismarte.project.command.order.GetOrderCommand;
import edu.programacion.avanzada.aluismarte.project.model.dto.OrderDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetOrderCommand.class)
@Slf4j
public class GetCheckoutCommandHandler implements CommandHandler<GetOrderResponse, GetOrderCommand> {

    private final OrderRepository orderRepository;

    @Override
    public GetOrderResponse handle(GetOrderCommand getOrderCommand) {
        log.debug("Get orders {}", getOrderCommand.getId());
        OrderDTO orderDTO = orderRepository.findById(getOrderCommand.getId()).orElseThrow().toDTO();
        return GetOrderResponse.builder()
                .orders(List.of(orderDTO))
                .build();
    }
}
