package edu.programacion.avanzada.aluismarte.project.command.order;

import edu.programacion.avanzada.aluismarte.project.domain.Order;
import edu.programacion.avanzada.aluismarte.project.model.response.order.RefundOrderResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.Command;
import edu.programacion.avanzada.aluismarte.project.patterns.saga.model.SagaPayLoadKey;
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
public class RefundOrderCommand extends Command<RefundOrderResponse> {

    public static final SagaPayLoadKey<UUID> ID = new SagaPayLoadKey<>("id", UUID.class);
    public static final SagaPayLoadKey<RefundOrderCommand> COMMAND = new SagaPayLoadKey<>("command", RefundOrderCommand.class);
    public static final SagaPayLoadKey<Order> ORDER = new SagaPayLoadKey<>("order", Order.class);

    private UUID id;
}
