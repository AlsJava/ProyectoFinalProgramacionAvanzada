package edu.programacion.avanzada.aluismarte.project.command.checkout;

import edu.programacion.avanzada.aluismarte.project.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
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
public class UpdatePaymentMethodCheckoutCommand extends Command<CheckoutUpdatePaymentMethodResponse> {

    private UUID id;
    private Long paymentMethod;
}
