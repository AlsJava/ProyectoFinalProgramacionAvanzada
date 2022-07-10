package edu.programacion.avanzada.aluismarte.project.repositories;

import edu.programacion.avanzada.aluismarte.project.domain.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
}
