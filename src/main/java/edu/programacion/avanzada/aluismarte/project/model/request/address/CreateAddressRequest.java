package edu.programacion.avanzada.aluismarte.project.model.request.address;

import edu.programacion.avanzada.aluismarte.project.command.address.CreateAddressCommand;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressRequest {

    @NotBlank
    private String name;
    private String description;

    public CreateAddressCommand toCommand() {
        return CreateAddressCommand.builder()
                .name(name)
                .description(description)
                .build();
    }
}
