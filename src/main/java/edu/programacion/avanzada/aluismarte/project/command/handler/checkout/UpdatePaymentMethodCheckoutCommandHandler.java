package edu.programacion.avanzada.aluismarte.project.command.handler.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.UpdatePaymentMethodCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Checkout;
import edu.programacion.avanzada.aluismarte.project.domain.PaymentMethod;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.CheckoutRepository;
import edu.programacion.avanzada.aluismarte.project.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdatePaymentMethodCheckoutCommand.class)
@Slf4j
public class UpdatePaymentMethodCheckoutCommandHandler implements CommandHandler<CheckoutUpdatePaymentMethodResponse, UpdatePaymentMethodCheckoutCommand> {

    private final PaymentMethodRepository paymentMethodRepository;
    private final CheckoutRepository checkoutRepository;

    @Override
    public CheckoutUpdatePaymentMethodResponse handle(UpdatePaymentMethodCheckoutCommand updatePaymentMethodCheckoutCommand) {
        log.debug("Update Payment Method to Checkout {}", updatePaymentMethodCheckoutCommand.getId());
        Checkout checkout = checkoutRepository.findById(updatePaymentMethodCheckoutCommand.getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(updatePaymentMethodCheckoutCommand.getPaymentMethod()).orElseThrow();
        checkout.setPaymentMethod(paymentMethod);
        checkoutRepository.save(checkout);
        return CheckoutUpdatePaymentMethodResponse.builder()
                .checkout(checkout.toDTO())
                .build();
    }
}
