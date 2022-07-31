package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.command.address.GetAddressCommand;
import edu.programacion.avanzada.aluismarte.project.command.address.GetAllAddressCommand;
import edu.programacion.avanzada.aluismarte.project.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.CreateAddressResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.DeleteAddressResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.GetAddressResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.UpdateAddressResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class AddressService {

    private final CommandBus commandBus;

    public GetAddressResponse getAll(Integer pageSize, Integer page, String name) {
        return commandBus.sendCommand(GetAllAddressCommand.builder()
                .pageSize(pageSize)
                .page(page)
                .name(name)
                .build());
    }

    public GetAddressResponse get(Long id) {
        return commandBus.sendCommand(GetAddressCommand.builder().id(id).build());
    }

    public CreateAddressResponse create(CreateAddressRequest createAddressRequest) {
        return commandBus.sendCommand(createAddressRequest.toCommand());
    }

    public UpdateAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        return commandBus.sendCommand(updateAddressRequest.toCommand());
    }

    public DeleteAddressResponse delete(DeleteAddressRequest deleteAddressRequest) {
        return commandBus.sendCommand(deleteAddressRequest.toCommand());
    }
}
