package edu.programacion.avanzada.aluismarte.project.model.request.address;

import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    private Long id;
    private String description;

}
