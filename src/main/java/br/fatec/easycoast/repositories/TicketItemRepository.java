package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketItemRepository extends JpaRepository<TicketItem, Integer> {
    List<TicketItem> findByTicketId(Integer ticketId);
}
