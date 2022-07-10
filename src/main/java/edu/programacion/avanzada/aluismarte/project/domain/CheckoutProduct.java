package edu.programacion.avanzada.aluismarte.project.domain;

import edu.programacion.avanzada.aluismarte.project.model.dto.CheckoutProductDTO;
import lombok.*;

import javax.persistence.*;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "checkouts_products")
public class CheckoutProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Product product;

    @Column
    private Long quantity;

    public CheckoutProductDTO toDTO() {
        return CheckoutProductDTO.builder()
                .id(id)
                .product(product.toDTO())
                .quantity(quantity)
                .build();
    }
}
