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

/**
 * @author aluis on 7/10/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<GetAddressResponse> getAll(@RequestParam(required = false, defaultValue = "10") Long pageSize,
                                                     @RequestParam(required = false, defaultValue = "1") Long page) {
        return ResponseEntity.ok(addressService.getAll(pageSize, page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@RequestBody CreateAddressRequest createAddressRequest) {
        return ResponseEntity.ok(addressService.create(createAddressRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> update(@RequestBody UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(addressService.update(updateAddressRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponse> delete(@RequestBody DeleteAddressRequest deleteEmployeeRequest) {
        return ResponseEntity.ok(addressService.delete(deleteEmployeeRequest));
    }
}
