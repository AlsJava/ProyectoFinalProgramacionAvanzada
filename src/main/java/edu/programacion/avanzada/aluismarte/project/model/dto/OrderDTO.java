package edu.programacion.avanzada.aluismarte.project.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderDTO {

    private UUID id;
    private AddressDTO address;
    private PaymentMethodDTO paymentMethod;
    private List<CheckoutProductDTO> productsToBuy;
    private BigDecimal total;
    private LocalDateTime buyDateTime;
    private Boolean refund;
}
