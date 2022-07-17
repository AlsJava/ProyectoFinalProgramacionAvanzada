package edu.programacion.avanzada.aluismarte.project.command.product;

import edu.programacion.avanzada.aluismarte.project.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.Command;
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
public class UpdateProductCommand extends Command<UpdateProductResponse> {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;
}
