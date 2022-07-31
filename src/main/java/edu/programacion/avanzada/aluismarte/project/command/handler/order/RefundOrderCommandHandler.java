package edu.programacion.avanzada.aluismarte.project.command.handler.order;

import edu.programacion.avanzada.aluismarte.project.command.order.RefundOrderCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.order.RefundOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.SagaOrchestrator;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.Saga;
import edu.programacion.avanzada.aluismarte.project.saga.SagaFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = RefundOrderCommand.class)
@Slf4j
public class RefundOrderCommandHandler implements CommandHandler<RefundOrderResponse, RefundOrderCommand> {

    private final SagaOrchestrator sagaOrchestrator;

    @Value("${pattern.saga.timeout}")
    private int timeout;

    @Override
    public RefundOrderResponse handle(RefundOrderCommand refundPayCheckoutCommand) {
        Saga<RefundOrderResponse> saga = SagaFactory.refundOrderSaga(UUID.randomUUID(), refundPayCheckoutCommand);
        return sagaOrchestrator.orchestrate(saga, timeout);
    }
}
