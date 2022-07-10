package edu.programacion.avanzada.aluismarte.project.command.handler;

import edu.programacion.avanzada.aluismarte.project.command.UpdateAddressCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Address;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.UpdateAddressResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCommand.class)
public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressResponse, UpdateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponse handle(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow();
        address.setDescription(updateAddressCommand.getDescription());
        addressRepository.save(address);
        return UpdateAddressResponse.builder().address(address.toDTO()).build();
    }
}
