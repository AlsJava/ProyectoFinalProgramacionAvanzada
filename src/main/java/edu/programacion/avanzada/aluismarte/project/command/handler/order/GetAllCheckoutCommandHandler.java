package edu.programacion.avanzada.aluismarte.project.command.handler.order;

import edu.programacion.avanzada.aluismarte.project.command.order.GetAllOrderCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Order;
import edu.programacion.avanzada.aluismarte.project.model.dto.OrderDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllOrderCommand.class)
@Slf4j
public class GetAllCheckoutCommandHandler implements CommandHandler<GetOrderResponse, GetAllOrderCommand> {

    private final OrderRepository orderRepository;

    @Override
    public GetOrderResponse handle(GetAllOrderCommand getAllOrderCommand) {
        log.debug("Get Orders {}", getAllOrderCommand.toString());
        List<OrderDTO> orders = orderRepository.findAll(
                        PageRequest.of(getAllOrderCommand.getPage(), getAllOrderCommand.getPageSize()))
                .stream()
                .map(Order::toDTO)
                .collect(Collectors.toList());
        return GetOrderResponse.builder()
                .orders(orders)
                .build();
    }
}
