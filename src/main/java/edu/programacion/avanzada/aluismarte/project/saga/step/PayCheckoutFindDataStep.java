package edu.programacion.avanzada.aluismarte.project.saga.step;

import edu.programacion.avanzada.aluismarte.project.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.aluismarte.project.saga.handler.PayCheckoutFinDataHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/17/2022.
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class PayCheckoutFindDataStep implements SagaStep<PayCheckoutResponse> {

    private final PayCheckoutFinDataHandler payCheckoutFinDataHandler;

    @Override
    public String getName() {
        return "Find Data";
    }

    @Override
    public SagaStepHandler<PayCheckoutResponse> getHandler() {
        return payCheckoutFinDataHandler;
    }

    @Override
    public SagaStepCompensator<PayCheckoutResponse> getCompensator() {
        return null;
    }
}
