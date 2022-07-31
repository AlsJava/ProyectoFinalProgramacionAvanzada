package edu.programacion.avanzada.aluismarte.project.saga.step;

import edu.programacion.avanzada.aluismarte.project.model.response.order.RefundOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.aluismarte.project.saga.handler.RefundOrderFindDataHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/31/2022.
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class RefundOrderFindDataStep implements SagaStep<RefundOrderResponse> {

    private final RefundOrderFindDataHandler refundOrderFindDataHandler;

    @Override
    public String getName() {
        return "Find Data";
    }

    @Override
    public SagaStepHandler<RefundOrderResponse> getHandler() {
        return refundOrderFindDataHandler;
    }

    @Override
    public SagaStepCompensator<RefundOrderResponse> getCompensator() {
        return null;
    }
}
