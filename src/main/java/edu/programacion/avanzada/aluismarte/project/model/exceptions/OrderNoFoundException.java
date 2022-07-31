package edu.programacion.avanzada.aluismarte.project.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author aluis on 7/31/2022.
 */
public class OrderNoFoundException extends RuntimeException {

    public OrderNoFoundException(UUID id) {
        super(MessageFormat.format("Order {0} no found", id));
    }
}
