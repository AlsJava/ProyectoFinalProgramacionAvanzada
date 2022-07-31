package edu.programacion.avanzada.aluismarte.project.command.handler.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.UpdatePaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.domain.PaymentMethod;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.UpdatePaymentMethodResponse;
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
@CommandEvent(command = UpdatePaymentMethodCommand.class)
@Slf4j
public class UpdatePaymentMethodCommandHandler implements CommandHandler<UpdatePaymentMethodResponse, UpdatePaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public UpdatePaymentMethodResponse handle(UpdatePaymentMethodCommand updatePaymentMethodCommand) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(updatePaymentMethodCommand.getId()).orElseThrow();
        paymentMethod.setDescription(updatePaymentMethodCommand.getDescription());
        paymentMethodRepository.save(paymentMethod);
        log.info("Payment Method {} updated", updatePaymentMethodCommand.getId());
        return UpdatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethod.toDTO())
                .build();
    }
}
