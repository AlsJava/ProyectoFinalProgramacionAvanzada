package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

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
}
