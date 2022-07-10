package edu.programacion.avanzada.aluismarte.project.command.handler;

import edu.programacion.avanzada.aluismarte.project.command.DeleteAddressCommand;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.DeleteAddressResponse;
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
@CommandEvent(command = DeleteAddressCommand.class)
public class DeleteAddressCommandHandler implements CommandHandler<DeleteAddressResponse, DeleteAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public DeleteAddressResponse handle(DeleteAddressCommand deleteAddressCommand) {
        addressRepository.deleteById(deleteAddressCommand.getId());
        return DeleteAddressResponse.builder()
                .build();
    }
}
