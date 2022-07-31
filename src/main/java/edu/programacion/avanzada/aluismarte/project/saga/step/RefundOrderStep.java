package edu.programacion.avanzada.aluismarte.project.saga.step;

import edu.programacion.avanzada.aluismarte.project.model.response.order.RefundOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.aluismarte.project.saga.handler.RefundOrderHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/31/2022.
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class RefundOrderStep implements SagaStep<RefundOrderResponse> {

    private final RefundOrderHandler refundOrderHandler;

    @Override
    public String getName() {
        return "Refund Order";
    }

    @Override
    public SagaStepHandler<RefundOrderResponse> getHandler() {
        return refundOrderHandler;
    }

    @Override
    public SagaStepCompensator<RefundOrderResponse> getCompensator() {
        return null;
    }
}
