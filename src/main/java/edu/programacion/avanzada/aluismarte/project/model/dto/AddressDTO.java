package edu.programacion.avanzada.aluismarte.project.model.dto;

import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String name;
    private String description;
}
