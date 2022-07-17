package edu.programacion.avanzada.aluismarte.project.command.product;

import edu.programacion.avanzada.aluismarte.project.model.response.product.GetProductResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.Command;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetProductCommand extends Command<GetProductResponse> {

    private Long id;
}
