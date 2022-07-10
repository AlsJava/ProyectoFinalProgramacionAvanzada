package edu.programacion.avanzada.aluismarte.project.model.response.product;

import edu.programacion.avanzada.aluismarte.project.model.dto.ProductDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductResponse {

    private ProductDTO product;
}
