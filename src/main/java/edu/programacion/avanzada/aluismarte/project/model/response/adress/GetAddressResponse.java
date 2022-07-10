package edu.programacion.avanzada.aluismarte.project.model.response.adress;

import edu.programacion.avanzada.aluismarte.project.model.dto.AddressDTO;
import lombok.*;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAddressResponse {

    private List<AddressDTO> addresses;
}
