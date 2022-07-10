package edu.programacion.avanzada.aluismarte.project.model.dto;

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
public class PaymentMethodDTO {

    private Long id;
    private String name;
    private String description;
}
