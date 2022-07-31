package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.AddProductCheckoutCommand;
import lombok.*;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductRequest {

    private UUID id;
    private Long product;
    private Long quantity;

    public AddProductCheckoutCommand toCommand() {
        return AddProductCheckoutCommand.builder()
                .id(id)
                .product(product)
                .quantity(quantity)
                .build();
    }
}
