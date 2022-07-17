package edu.programacion.avanzada.aluismarte.project.command.product;

import edu.programacion.avanzada.aluismarte.project.domain.Product;
import edu.programacion.avanzada.aluismarte.project.model.response.product.CreateProductResponse;
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
public class CreateProductCommand extends Command<CreateProductResponse> {

    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}
