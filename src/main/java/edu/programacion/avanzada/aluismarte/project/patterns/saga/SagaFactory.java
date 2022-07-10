package edu.programacion.avanzada.aluismarte.project.patterns.saga;

import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.Saga;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayload;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {

    // TODO demo de como hacer una SAGA
//    public static Saga<DemoResponse> createDemoSaga(String key, Demo demo) {
//        SagaPayload<DemoResponse> sagaPayload = new SagaPayload<>();
//        sagaPayload.addProperty(new SagaPayLoadKey<>("MyId", Demo.class), demo);
//        return Saga.<DemoResponse>builder()
//                .name("Hola")
//                .key("My Key")
//                .payload(sagaPayload)
//                .requiredStep(List.of(
//                        SagaDemoStep1.class,
//                        SagaDemoStep2.class
//                ))
//                .build();
//    }
}
