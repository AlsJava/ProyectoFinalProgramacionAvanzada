package edu.programacion.avanzada.aluismarte.project.model.response.checkout;

import edu.programacion.avanzada.aluismarte.project.model.dto.CheckoutDTO;
import edu.programacion.avanzada.aluismarte.project.model.dto.PaymentMethodDTO;
import lombok.*;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCheckoutResponse {

    private List<CheckoutDTO> checkouts;
}
