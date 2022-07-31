package edu.programacion.avanzada.aluismarte.project.command.payment;

import edu.programacion.avanzada.aluismarte.project.model.response.payment.UpdatePaymentMethodResponse;
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
public class UpdatePaymentMethodCommand extends Command<UpdatePaymentMethodResponse> {

    private Long id;
    private String description;
}
