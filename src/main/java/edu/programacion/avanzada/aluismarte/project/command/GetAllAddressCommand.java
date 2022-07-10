package edu.programacion.avanzada.aluismarte.project.command;

import edu.programacion.avanzada.aluismarte.project.model.response.adress.GetAddressResponse;
import edu.programacion.avanzada.aluismarte.project.patterns.command.Command;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllAddressCommand extends Command<GetAddressResponse> {

    private long pageSize;
    private long page;

}
