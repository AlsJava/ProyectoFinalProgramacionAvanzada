package edu.programacion.avanzada.aluismarte.project.patterns.saga.model;

public class SagaException extends RuntimeException {

    public SagaException(Throwable cause) {
        super(cause);
    }
}
