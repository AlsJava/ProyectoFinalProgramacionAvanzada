package edu.programacion.avanzada.aluismarte.project.command.checkout;

import edu.programacion.avanzada.aluismarte.project.model.response.checkout.GetCheckoutResponse;
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
public class GetAllCheckoutCommand extends Command<GetCheckoutResponse> {

    private int pageSize;
    private int page;
}
