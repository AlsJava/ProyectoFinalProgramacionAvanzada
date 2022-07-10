package edu.programacion.avanzada.aluismarte.project.domain;

import edu.programacion.avanzada.aluismarte.project.model.dto.AddressDTO;
import edu.programacion.avanzada.aluismarte.project.model.request.address.UpdateAddressRequest;
import lombok.*;

import javax.persistence.*;

/**
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

    @Column
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

    public void applyChanges(UpdateAddressRequest updateAddressRequest) {
        description = updateAddressRequest.getDescription();
    }

}
