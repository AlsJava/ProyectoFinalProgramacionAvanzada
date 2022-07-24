package edu.programacion.avanzada.aluismarte.project.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author aluis on 7/17/2022.
 */
public class CheckoutAddressNoAssignedException extends RuntimeException {

    public CheckoutAddressNoAssignedException(UUID id) {
        super(MessageFormat.format("No Address in checkout {0} ", id));
    }
}
