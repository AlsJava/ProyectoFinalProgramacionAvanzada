package edu.programacion.avanzada.aluismarte.project.domain;

import edu.programacion.avanzada.aluismarte.project.model.dto.AddressDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * INSERT INTO ADDRESSES(id, name, description) VALUES (1, 'Demo Address', '')
 * INSERT INTO ADDRESSES(id, name, description) VALUES (2, 'Demo Address 2', '')
 *
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    public AddressDTO toDTO() {
        return AddressDTO.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
