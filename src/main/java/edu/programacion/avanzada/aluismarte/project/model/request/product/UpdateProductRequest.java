package edu.programacion.avanzada.aluismarte.project.model.request.product;

import edu.programacion.avanzada.aluismarte.project.command.product.UpdateProductCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
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

    @NotNull
    @Positive
    private Long id;
    private String description;
    @NotNull
    @PositiveOrZero
    private Long availableQuantity;

    @NotNull
    private BigDecimal price;

    public UpdateProductCommand toCommand() {
        return UpdateProductCommand.builder()
                .id(id)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }

}
