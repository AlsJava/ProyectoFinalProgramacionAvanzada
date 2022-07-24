package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.aluismarte.project.model.response.adress.CreateAddressResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author aluis on 7/24/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private AddressController addressController;

    @Test
    void checkCreateAddressRequestTest() {
        CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
                .name(null)
                .build();
        ResponseEntity<CreateAddressResponse> response = addressController.create(createAddressRequest);
        assertNotNull(response);
        CreateAddressResponse body = response.getBody();
        assertNotNull(body);
    }

}