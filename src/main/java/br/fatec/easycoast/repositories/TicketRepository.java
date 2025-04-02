package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByCheckoutId(Integer checkoutId);
}
