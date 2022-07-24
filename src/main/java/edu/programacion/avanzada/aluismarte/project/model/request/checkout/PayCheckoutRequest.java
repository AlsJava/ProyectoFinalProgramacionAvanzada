package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.PayCheckoutCommand;
import lombok.*;

import java.util.UUID;

/**
 * @author aluis on 7/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutRequest {

    private UUID id;

    public PayCheckoutCommand toCommand() {
        return PayCheckoutCommand.builder()
                .id(id)
                .build();
    }
}
