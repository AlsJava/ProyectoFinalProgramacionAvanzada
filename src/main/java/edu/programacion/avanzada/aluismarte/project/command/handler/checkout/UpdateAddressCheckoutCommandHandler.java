package edu.programacion.avanzada.aluismarte.project.command.handler.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.UpdateAddressCheckoutCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Address;
import edu.programacion.avanzada.aluismarte.project.domain.Checkout;
import edu.programacion.avanzada.aluismarte.project.model.response.checkout.CheckoutUpdateAddressResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.AddressRepository;
import edu.programacion.avanzada.aluismarte.project.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/31/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCheckoutCommand.class)
@Slf4j
public class UpdateAddressCheckoutCommandHandler implements CommandHandler<CheckoutUpdateAddressResponse, UpdateAddressCheckoutCommand> {

    private final AddressRepository addressRepository;
    private final CheckoutRepository checkoutRepository;

    @Override
    public CheckoutUpdateAddressResponse handle(UpdateAddressCheckoutCommand updateAddressCheckoutCommand) {
        log.debug("Update Address Checkout {}", updateAddressCheckoutCommand.getId());
        Checkout checkout = checkoutRepository.findById(updateAddressCheckoutCommand.getId()).orElseThrow();
        Address address = addressRepository.findById(updateAddressCheckoutCommand.getAddress()).orElseThrow();
        checkout.setAddress(address);
        checkoutRepository.save(checkout);
        return CheckoutUpdateAddressResponse.builder().checkout(checkout.toDTO()).build();
    }
}
