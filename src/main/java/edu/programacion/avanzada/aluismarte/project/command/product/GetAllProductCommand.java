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
@ToString
public class GetAllProductCommand extends Command<GetProductResponse> {

    private int pageSize;
    private int page;

}
