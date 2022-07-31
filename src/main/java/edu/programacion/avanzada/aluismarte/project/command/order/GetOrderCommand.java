package edu.programacion.avanzada.aluismarte.project.command.order;

import edu.programacion.avanzada.aluismarte.project.model.response.order.GetOrderResponse;
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
public class GetOrderCommand extends Command<GetOrderResponse> {

    private UUID id;
}
