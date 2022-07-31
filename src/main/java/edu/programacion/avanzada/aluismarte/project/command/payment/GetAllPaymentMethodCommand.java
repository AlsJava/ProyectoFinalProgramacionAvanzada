package edu.programacion.avanzada.aluismarte.project.command.payment;

import edu.programacion.avanzada.aluismarte.project.model.response.payment.GetPaymentMethodResponse;
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
@ToString
public class GetAllPaymentMethodCommand extends Command<GetPaymentMethodResponse> {

    private int pageSize;
    private int page;
}
