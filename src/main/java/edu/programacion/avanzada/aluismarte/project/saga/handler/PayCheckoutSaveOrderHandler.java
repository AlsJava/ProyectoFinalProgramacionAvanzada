package edu.programacion.avanzada.aluismarte.project.saga.handler;

import edu.programacion.avanzada.aluismarte.project.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Order;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/24/2022.
 */
@RequiredArgsConstructor
@Component
public class PayCheckoutSaveOrderHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        Order order = sagaPayload.getProperty(PayCheckoutCommand.ORDER);
        orderRepository.save(order);
    }
}
