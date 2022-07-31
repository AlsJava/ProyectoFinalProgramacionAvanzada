package edu.programacion.avanzada.aluismarte.project.command.handler.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.GetPaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetPaymentMethodCommand.class)
@Slf4j
public class GetPaymentMethodCommandHandler implements CommandHandler<GetPaymentMethodResponse, GetPaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public GetPaymentMethodResponse handle(GetPaymentMethodCommand getPaymentMethodCommand) {
        log.debug("Get payment method {}", getPaymentMethodCommand.getId());
        PaymentMethodDTO paymentMethodDTO = paymentMethodRepository.findById(getPaymentMethodCommand.getId()).orElseThrow().toDTO();
        return GetPaymentMethodResponse.builder()
                .paymentMethods(List.of(paymentMethodDTO))
                .build();
    }
}
