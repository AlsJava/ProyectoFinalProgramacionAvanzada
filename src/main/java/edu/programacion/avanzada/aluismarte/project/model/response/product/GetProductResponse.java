package edu.programacion.avanzada.aluismarte.project.model.response.product;

import edu.programacion.avanzada.aluismarte.project.model.dto.ProductDTO;
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
public class GetProductResponse {

    private List<ProductDTO> products;
}
