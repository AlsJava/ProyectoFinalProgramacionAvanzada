package edu.programacion.avanzada.aluismarte.project.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author aluis on 7/17/2022.
 */
public class CheckoutNoFoundException extends RuntimeException {

    public CheckoutNoFoundException(UUID id) {
        super(MessageFormat.format("Checkout {0} no found", id));
    }
}
