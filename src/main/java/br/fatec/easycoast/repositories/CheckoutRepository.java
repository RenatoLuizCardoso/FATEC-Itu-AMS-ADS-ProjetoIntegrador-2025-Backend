package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
    Optional<Checkout> findByStatus(String status);
}
