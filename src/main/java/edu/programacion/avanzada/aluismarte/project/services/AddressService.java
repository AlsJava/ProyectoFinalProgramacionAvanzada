package edu.programacion.avanzada.aluismarte.project.services;

import edu.programacion.avanzada.aluismarte.project.domain.Address;
import edu.programacion.avanzada.aluismarte.project.model.dto.AddressDTO;
import edu.programacion.avanzada.aluismarte.project.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 7/10/2022.
 */
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<AddressDTO> getAll() {
        return addressRepository.findAll().stream().map(Address::toDTO).collect(Collectors.toList());
    }

    public AddressDTO create(CreateAddressRequest createAddressRequest) {
        Address address = addressRepository.save(createAddressRequest.toPaymentMethod());
        return address.toDTO();
    }

    public AddressDTO update(UpdateAddressRequest updateAddressRequest) {
        Address address = addressRepository.findById(updateAddressRequest.getId()).orElseThrow();
        address.applyChanges(updateAddressRequest);
        addressRepository.save(address);
        return address.toDTO();
    }

    public void delete(DeleteAddressRequest deleteAddressRequest) {
        addressRepository.deleteById(deleteAddressRequest.getId());
    }
}
