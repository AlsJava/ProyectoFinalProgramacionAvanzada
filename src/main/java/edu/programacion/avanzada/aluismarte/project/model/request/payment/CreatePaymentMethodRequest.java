package edu.programacion.avanzada.aluismarte.project.model.request.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.CreatePaymentMethodCommand;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodRequest {

    private String name;
    private String description;

    public CreatePaymentMethodCommand toCommand() {
        return CreatePaymentMethodCommand.builder()
                .name(name)
                .description(description)
                .build();
    }
}
