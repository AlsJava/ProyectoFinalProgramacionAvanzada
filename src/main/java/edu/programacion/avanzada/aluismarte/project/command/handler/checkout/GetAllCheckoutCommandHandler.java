package edu.programacion.avanzada.aluismarte.project.command.handler.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.GetAllCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Checkout;
import edu.programacion.avanzada.aluismarte.project.model.dto.CheckoutDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.GetCheckoutResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.CheckoutRepository;
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
@CommandEvent(command = GetAllCheckoutCommand.class)
@Slf4j
public class GetAllCheckoutCommandHandler implements CommandHandler<GetCheckoutResponse, GetAllCheckoutCommand> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public GetCheckoutResponse handle(GetAllCheckoutCommand getAllCheckoutCommand) {
        log.debug("Get Checkouts {}", getAllCheckoutCommand.toString());
        List<CheckoutDTO> checkoutDTOS = checkoutRepository.findAll(
                        PageRequest.of(getAllCheckoutCommand.getPage(), getAllCheckoutCommand.getPageSize()))
                .stream()
                .map(Checkout::toDTO)
                .collect(Collectors.toList());
        return GetCheckoutResponse.builder()
                .checkouts(checkoutDTOS)
                .build();
    }
}
