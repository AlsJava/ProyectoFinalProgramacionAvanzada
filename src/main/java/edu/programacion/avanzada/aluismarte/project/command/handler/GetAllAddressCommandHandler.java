package edu.programacion.avanzada.aluismarte.project.command.handler;

import edu.programacion.avanzada.aluismarte.project.command.GetAllAddressCommand;
import edu.programacion.avanzada.aluismarte.project.domain.Address;
import edu.programacion.avanzada.aluismarte.project.model.dto.AddressDTO;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.GetAddressResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandEvent;
import edu.programacion.avanzada.aluismarte.project.patterns.command.CommandHandler;
import edu.programacion.avanzada.aluismarte.project.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllAddressCommand.class)
@Slf4j
public class GetAllAddressCommandHandler implements CommandHandler<GetAddressResponse, GetAllAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public GetAddressResponse handle(GetAllAddressCommand getAllAddressCommand) {
        log.info("Get Addresses {}", getAllAddressCommand.toString());
        List<AddressDTO> addressDTOS = addressRepository.findAll().stream().map(Address::toDTO).collect(Collectors.toList());
        return GetAddressResponse.builder()
                .addresses(addressDTOS)
                .build();
    }
}
