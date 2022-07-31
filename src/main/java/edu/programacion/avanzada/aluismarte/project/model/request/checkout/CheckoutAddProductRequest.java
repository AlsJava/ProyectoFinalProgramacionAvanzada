package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.AddProductCheckoutCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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

    @NotNull
    private UUID id;
    @NotNull
    @Positive
    private Long product;
    @NotNull
    @Positive
    private Long quantity;

    public AddProductCheckoutCommand toCommand() {
        return AddProductCheckoutCommand.builder()
                .id(id)
                .product(product)
                .quantity(quantity)
                .build();
    }
}
