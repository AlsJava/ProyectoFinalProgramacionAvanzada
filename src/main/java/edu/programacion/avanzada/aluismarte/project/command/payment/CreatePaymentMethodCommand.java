package edu.programacion.avanzada.aluismarte.project.command.payment;

import edu.programacion.avanzada.aluismarte.project.domain.PaymentMethod;
import edu.programacion.avanzada.aluismarte.project.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.Command;
import lombok.*;

/**
 * @author aluis on 7/31/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodCommand extends Command<CreatePaymentMethodResponse> {

    private String name;
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }

}
