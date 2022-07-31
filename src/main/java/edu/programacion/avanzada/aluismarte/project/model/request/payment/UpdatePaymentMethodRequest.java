package edu.programacion.avanzada.aluismarte.project.model.request.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.UpdatePaymentMethodCommand;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodRequest {

    private Long id;
    private String description;

    public UpdatePaymentMethodCommand toCommand() {
        return UpdatePaymentMethodCommand.builder()
                .id(id)
                .description(description)
                .build();
    }
}
