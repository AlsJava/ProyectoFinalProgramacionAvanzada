package edu.programacion.avanzada.aluismarte.project.command.handler;

import edu.programacion.avanzada.aluismarte.project.command.DemoCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.DemoResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.SagaOrchestrator;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.Saga;
import edu.programacion.avanzada.aluismarte.project.saga.SagaFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = DemoCommand.class)
@Slf4j
public class DemoCommandHandler implements CommandHandler<DemoResponse, DemoCommand> {

    private final SagaOrchestrator sagaOrchestrator;

    @Value("${pattern.saga.timeout}")
    private int timeout;

    @Override
    public DemoResponse handle(DemoCommand command) {
        Saga<DemoResponse> saga = SagaFactory.createDemoSaga(UUID.randomUUID(), command);
        return sagaOrchestrator.orchestrate(saga, timeout);
    }
}
