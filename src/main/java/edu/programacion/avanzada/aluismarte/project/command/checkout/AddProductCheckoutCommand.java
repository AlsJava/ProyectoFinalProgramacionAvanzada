package edu.programacion.avanzada.aluismarte.project.command.checkout;

import edu.programacion.avanzada.aluismarte.project.model.response.checkout.CheckoutAddProductResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.Command;
import lombok.*;

import java.util.UUID;

/**
 * @author aluis on 7/31/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddProductCheckoutCommand extends Command<CheckoutAddProductResponse> {

    private UUID id;
    private Long product;
    private Long quantity;
}
