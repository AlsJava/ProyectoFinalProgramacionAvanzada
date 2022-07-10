package edu.programacion.avanzada.aluismarte.project.model.response.payment;

import edu.programacion.avanzada.aluismarte.project.model.dto.PaymentMethodDTO;
import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodResponse {

    private PaymentMethodDTO paymentMethod;
}
