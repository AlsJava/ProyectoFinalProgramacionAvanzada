package edu.programacion.avanzada.aluismarte.project.model.request.order;

import edu.programacion.avanzada.aluismarte.project.command.order.RefundOrderCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author aluis on 7/31/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RefundOrderRequest {

    @NotNull
    private UUID id;

    public RefundOrderCommand toCommand() {
        return RefundOrderCommand.builder()
                .id(id)
                .build();
    }
}
