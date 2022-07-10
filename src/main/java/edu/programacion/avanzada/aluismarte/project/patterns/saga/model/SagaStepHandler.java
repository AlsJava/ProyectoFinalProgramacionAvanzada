package edu.programacion.avanzada.aluismarte.project.patterns.saga.model;

public interface SagaStepHandler<T> {

    void handle(SagaPayload<T> sagaPayload);
}
