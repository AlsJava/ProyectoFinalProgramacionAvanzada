package edu.programacion.avanzada.aluismarte.project.controllers;

import edu.programacion.avanzada.aluismarte.project.model.request.address.CreateAddressRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

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
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                addressController.create(createAddressRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
    }

    @Test
    void checkCreateAddressRequest_minNameSizeTest() {
        CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
                .name("123")
                .build();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                addressController.create(createAddressRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
    }

    @Test
    void checkCreateAddressRequest_maxNameSizeTest() {
        CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
                .name("0123456789A")
                .build();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                addressController.create(createAddressRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
    }

}