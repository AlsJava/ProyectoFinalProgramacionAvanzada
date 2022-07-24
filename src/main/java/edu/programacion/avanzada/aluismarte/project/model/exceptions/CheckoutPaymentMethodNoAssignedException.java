package edu.programacion.avanzada.aluismarte.project.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author aluis on 7/17/2022.
 */
public class CheckoutPaymentMethodNoAssignedException extends RuntimeException {

    public CheckoutPaymentMethodNoAssignedException(UUID id) {
        super(MessageFormat.format("No payment method in checkout {0} ", id));
    }
}
