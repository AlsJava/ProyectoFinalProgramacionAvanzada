package edu.programacion.avanzada.aluismarte.project.domain;

import edu.programacion.avanzada.aluismarte.project.model.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * INSERT INTO PRODUCTS(id, name, description, AVAILABLE_QUANTITY, PRICE ) VALUES (1, 'Uvas', '', 500, 250)
 *
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private long availableQuantity;

    @Column
    private BigDecimal price;

    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .id(id)
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }

}
