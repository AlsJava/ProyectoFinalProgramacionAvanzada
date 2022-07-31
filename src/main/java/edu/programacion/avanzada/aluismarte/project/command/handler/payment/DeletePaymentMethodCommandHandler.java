package edu.programacion.avanzada.aluismarte.project.command.handler.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.DeletePaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.DeletePaymentMethodResponse;
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
@CommandEvent(command = DeletePaymentMethodCommand.class)
@Slf4j
public class DeletePaymentMethodCommandHandler implements CommandHandler<DeletePaymentMethodResponse, DeletePaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public DeletePaymentMethodResponse handle(DeletePaymentMethodCommand deletePaymentMethodCommand) {
        paymentMethodRepository.deleteById(deletePaymentMethodCommand.getId());
        log.info("Payment Method {} deleted", deletePaymentMethodCommand.getId());
        return DeletePaymentMethodResponse.builder()
                .build();
    }
}
