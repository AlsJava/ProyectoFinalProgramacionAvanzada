package edu.programacion.avanzada.aluismarte.project.command.handler.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.GetAllPaymentMethodCommand;
import edu.programacion.avanzada.aluismarte.project.domain.PaymentMethod;
import edu.programacion.avanzada.aluismarte.project.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllPaymentMethodCommand.class)
@Slf4j
public class GetAllPaymentMethodCommandHandler implements CommandHandler<GetPaymentMethodResponse, GetAllPaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public GetPaymentMethodResponse handle(GetAllPaymentMethodCommand getAllPaymentMethodCommand) {
        log.debug("Get payment methods {}", getAllPaymentMethodCommand.toString());
        List<PaymentMethodDTO> paymentMethodDTOS = paymentMethodRepository.findAll(
                        PageRequest.of(getAllPaymentMethodCommand.getPage(), getAllPaymentMethodCommand.getPageSize()))
                .stream()
                .map(PaymentMethod::toDTO)
                .collect(Collectors.toList());
        return GetPaymentMethodResponse.builder()
                .paymentMethods(paymentMethodDTOS)
                .build();
    }
}
