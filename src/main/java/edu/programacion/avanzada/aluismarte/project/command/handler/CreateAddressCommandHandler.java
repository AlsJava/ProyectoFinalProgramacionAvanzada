package edu.programacion.avanzada.aluismarte.project.command.handler;

import edu.programacion.avanzada.aluismarte.project.command.CreateAddressCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Address;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.CreateAddressResponse;
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
@CommandEvent(command = CreateAddressCommand.class)
public class CreateAddressCommandHandler implements CommandHandler<CreateAddressResponse, CreateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public CreateAddressResponse handle(CreateAddressCommand createAddressCommand) {
        Address address = addressRepository.save(createAddressCommand.toPaymentMethod());
        return CreateAddressResponse.builder()
                .address(address.toDTO())
                .build();
    }
}
