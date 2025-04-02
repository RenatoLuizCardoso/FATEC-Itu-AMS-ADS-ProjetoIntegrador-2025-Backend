package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByTicketId(Integer ticketId);
}
