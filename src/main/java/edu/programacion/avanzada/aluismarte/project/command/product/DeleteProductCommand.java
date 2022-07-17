package edu.programacion.avanzada.aluismarte.project.command.product;

import edu.programacion.avanzada.aluismarte.project.model.response.product.DeleteProductResponse;
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
public class DeleteProductCommand extends Command<DeleteProductResponse> {

    private Long id;
}
