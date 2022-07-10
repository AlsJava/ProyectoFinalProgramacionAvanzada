package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.CreateAddressResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.DeleteAddressResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.GetAddressResponse;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.UpdateAddressResponse;
import edu.programacion.avanzada.aluismarte.project.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<GetAddressResponse> get() {
        return ResponseEntity.ok(GetAddressResponse.builder()
                .addresses(addressService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@RequestParam Long id) {
        return ResponseEntity.ok(GetAddressResponse.builder()
                .addresses(List.of(addressService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@RequestBody CreateAddressRequest createAddressRequest) {
        return ResponseEntity.ok(CreateAddressResponse.builder()
                .address(addressService.create(createAddressRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> update(@RequestBody UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(UpdateAddressResponse.builder()
                .address(addressService.update(updateAddressRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponse> delete(@RequestBody DeleteAddressRequest deleteEmployeeRequest) {
        addressService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeleteAddressResponse.builder().build());
    }
}
