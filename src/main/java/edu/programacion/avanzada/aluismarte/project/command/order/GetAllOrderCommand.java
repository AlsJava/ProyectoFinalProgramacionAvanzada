package edu.programacion.avanzada.aluismarte.project.command.order;

import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
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
public class GetAllOrderCommand extends Command<GetOrderResponse> {

    private int pageSize;
    private int page;
}
