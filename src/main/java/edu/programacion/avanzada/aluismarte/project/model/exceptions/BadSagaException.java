package edu.programacion.avanzada.aluismarte.project.model.exceptions;

/**
 * @author aluis on 7/17/2022.
 */
public class BadSagaException extends RuntimeException {

    public BadSagaException() {
        super("Mi Saga do BUM!");
    }
}
