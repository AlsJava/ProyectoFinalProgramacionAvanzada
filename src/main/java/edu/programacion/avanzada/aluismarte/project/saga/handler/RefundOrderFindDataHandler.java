package edu.programacion.avanzada.aluismarte.project.saga.handler;

import edu.programacion.avanzada.aluismarte.project.command.order.RefundOrderCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Order;
import edu.programacion.avanzada.aluismarte.project.model.exceptions.OrderNoFoundException;
import edu.programacion.avanzada.aluismarte.project.model.response.order.RefundOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/31/2022.
 */
@RequiredArgsConstructor
@Component
public class RefundOrderFindDataHandler implements SagaStepHandler<RefundOrderResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<RefundOrderResponse> sagaPayload) {
        RefundOrderCommand command = sagaPayload.getProperty(RefundOrderCommand.COMMAND);
        Order order = orderRepository.findById(command.getId()).orElseThrow(() -> new OrderNoFoundException(command.getId()));

        sagaPayload.addProperty(RefundOrderCommand.ORDER, order);
    }
}
