package edu.programacion.avanzada.aluismarte.project.repositories;

import edu.programacion.avanzada.aluismarte.project.domain.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aluis on 7/10/2022.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
