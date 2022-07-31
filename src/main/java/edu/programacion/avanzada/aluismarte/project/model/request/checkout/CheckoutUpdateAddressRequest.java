package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.UpdateAddressCheckoutCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUpdateAddressRequest {

    @NotNull
    private UUID id;

    @NotNull
    @Positive
    private Long address;

    public UpdateAddressCheckoutCommand toCommand() {
        return UpdateAddressCheckoutCommand.builder()
                .id(id)
                .address(address)
                .build();
    }
}
