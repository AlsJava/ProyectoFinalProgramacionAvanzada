package edu.programacion.avanzada.aluismarte.project.model.request.payment;

import lombok.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeletePaymentMethodRequest {

    private Long id;
}
