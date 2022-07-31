package edu.programacion.avanzada.aluismarte.project.command.handler.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.GetCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.model.dto.CheckoutDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.GetCheckoutResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetCheckoutCommand.class)
@Slf4j
public class GetCheckoutCommandHandler implements CommandHandler<GetCheckoutResponse, GetCheckoutCommand> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public GetCheckoutResponse handle(GetCheckoutCommand getCheckoutCommand) {
        log.debug("Get Checkout {}", getCheckoutCommand.getId());
        CheckoutDTO checkoutDTO = checkoutRepository.findById(getCheckoutCommand.getId()).orElseThrow().toDTO();
        return GetCheckoutResponse.builder()
                .checkouts(List.of(checkoutDTO))
                .build();
    }
}
