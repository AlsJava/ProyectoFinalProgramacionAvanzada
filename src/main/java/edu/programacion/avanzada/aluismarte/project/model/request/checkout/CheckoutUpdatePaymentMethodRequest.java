package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.UpdatePaymentMethodCheckoutCommand;
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
public class CheckoutUpdatePaymentMethodRequest {

    private UUID id;
    private Long paymentMethod;

    public UpdatePaymentMethodCheckoutCommand toCommand() {
        return UpdatePaymentMethodCheckoutCommand.builder()
                .id(id)
                .paymentMethod(paymentMethod)
                .build();
    }
}
