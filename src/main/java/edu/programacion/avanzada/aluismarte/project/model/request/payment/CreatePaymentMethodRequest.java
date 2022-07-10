package edu.programacion.avanzada.aluismarte.project.model.request.payment;

import edu.programacion.avanzada.aluismarte.project.domain.PaymentMethod;
import edu.programacion.avanzada.aluismarte.project.domain.Product;
import edu.programacion.avanzada.aluismarte.project.model.dto.PaymentMethodDTO;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodRequest {

    private String name;
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }
}