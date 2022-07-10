package edu.programacion.avanzada.aluismarte.project.patterns.saga.model;

import lombok.Getter;

@Getter
public class SagaPayLoadKey<T> {

    private final String id;
    private Class<T> type;

    public SagaPayLoadKey(String id, Class<T> type) {
        this.id = id;
        this.type = type;
    }
}
