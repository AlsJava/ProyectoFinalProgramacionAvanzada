package edu.programacion.avanzada.aluismarte.project.model.response.checkout;

import edu.programacion.avanzada.aluismarte.project.model.dto.OrderDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutResponse {

    private OrderDTO orderDTO;
}
