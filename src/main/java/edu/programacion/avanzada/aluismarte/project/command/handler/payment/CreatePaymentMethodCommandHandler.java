package edu.programacion.avanzada.aluismarte.project.command.handler.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.CreatePaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.domain.PaymentMethod;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CreatePaymentMethodCommand.class)
@Slf4j
public class CreatePaymentMethodCommandHandler implements CommandHandler<CreatePaymentMethodResponse, CreatePaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public CreatePaymentMethodResponse handle(CreatePaymentMethodCommand createPaymentMethodCommand) {
        PaymentMethod paymentMethod = paymentMethodRepository.save(createPaymentMethodCommand.toPaymentMethod());
        log.info("Payment Method {} created", paymentMethod.getId());
        return CreatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethod.toDTO())
                .build();
    }
}
