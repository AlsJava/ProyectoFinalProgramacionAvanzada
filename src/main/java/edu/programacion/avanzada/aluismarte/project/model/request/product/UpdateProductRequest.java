package edu.programacion.avanzada.aluismarte.project.model.request.product;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductRequest {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

}
