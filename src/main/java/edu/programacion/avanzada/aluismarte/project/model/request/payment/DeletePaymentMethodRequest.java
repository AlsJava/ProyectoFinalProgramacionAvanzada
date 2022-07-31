package edu.programacion.avanzada.aluismarte.project.model.request.payment;

import edu.programacion.avanzada.aluismarte.project.command.payment.DeletePaymentMethodCommand;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeletePaymentMethodRequest {

    private Long id;

    public DeletePaymentMethodCommand toCommand() {
        return DeletePaymentMethodCommand.builder()
                .id(id)
                .build();
    }
}
