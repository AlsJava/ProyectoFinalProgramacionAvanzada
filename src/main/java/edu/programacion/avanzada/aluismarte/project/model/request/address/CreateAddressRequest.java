package edu.programacion.avanzada.aluismarte.project.model.request.address;

import edu.programacion.avanzada.aluismarte.project.domain.Address;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressRequest {

    private String name;
    private String description;

    public Address toPaymentMethod() {
        return Address.builder()
                .name(name)
                .description(description)
                .build();
    }
}
