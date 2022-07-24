package edu.programacion.avanzada.aluismarte.project.saga.handler;

import edu.programacion.avanzada.aluismarte.project.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaStepHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author aluis on 7/24/2022.
 */
@RequiredArgsConstructor
@Component
public class PayCheckoutCompletePaymentHandler implements SagaStepHandler<PayCheckoutResponse> {

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        String paymentIntent = sagaPayload.getProperty(PayCheckoutCommand.PAYMENT_INTENT);
        // Aquí terminaría mi payment intent con mastercard para que el balance se procese.
        if (LocalDateTime.now().getMinute() % 2 == 0) { // Condición de fallo dinámico puesto para ejemplo
            throw new RuntimeException("Error on process payment intent " + paymentIntent);
        }
    }
}
