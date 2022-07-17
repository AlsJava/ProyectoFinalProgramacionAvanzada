package edu.programacion.avanzada.aluismarte.project.saga;

import edu.programacion.avanzada.aluismarte.project.command.DemoCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.DemoResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.Saga;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.aluismarte.project.saga.step.SagaDemoStep1;
import edu.programacion.avanzada.aluismarte.project.saga.step.SagaDemoStep2;
import edu.programacion.avanzada.aluismarte.project.saga.step.SagaDemoStepFinal;
import edu.programacion.avanzada.aluismarte.project.saga.step.SagaDemoStepTrueFinal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {
    public static Saga<DemoResponse> createDemoSaga(UUID key, DemoCommand command) {
        SagaPayload<DemoResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(new SagaPayLoadKey<>("command", DemoCommand.class), command);
        return Saga.<DemoResponse>builder()
                .name("Demo Saga")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        SagaDemoStep1.class,
                        SagaDemoStep2.class,
                        SagaDemoStepFinal.class,
                        SagaDemoStepTrueFinal.class
                ))
                .build();
    }
}
