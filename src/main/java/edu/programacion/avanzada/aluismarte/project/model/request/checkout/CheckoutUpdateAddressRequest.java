package edu.programacion.avanzada.aluismarte.project.model.request.checkout;

import edu.programacion.avanzada.aluismarte.project.command.checkout.UpdateAddressCheckoutCommand;
import lombok.*;

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

    private UUID id;

    private Long address;

    public UpdateAddressCheckoutCommand toCommand() {
        return UpdateAddressCheckoutCommand.builder()
                .id(id)
                .address(address)
                .build();
    }
}
