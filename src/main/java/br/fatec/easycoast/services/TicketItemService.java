package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.TicketItemRequest;
import br.fatec.easycoast.dtos.TicketItemResponse;
import br.fatec.easycoast.entities.Ticket;
import br.fatec.easycoast.entities.TicketItem;
import br.fatec.easycoast.repositories.TicketItemRepository;
import br.fatec.easycoast.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketItemService {

    @Autowired
    private TicketItemRepository ticketItemRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public TicketItemResponse createTicketItem(Integer ticketId, TicketItemRequest request) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

        TicketItem ticketItem = new TicketItem();
        ticketItem.setTicket(ticket);
        ticketItem.setDescription(request.description());
        ticketItem.setPrice(request.price());
        ticketItem.setQuantity(request.quantity());

        TicketItem savedTicketItem = ticketItemRepository.save(ticketItem);

        return new TicketItemResponse(
                savedTicketItem.getId(),
                savedTicketItem.getDescription(),
                savedTicketItem.getPrice(),
                savedTicketItem.getQuantity()
        );
    }

    public List<TicketItemResponse> getItemsByTicketId(Integer ticketId) {
        List<TicketItem> items = ticketItemRepository.findByTicketId(ticketId);
        return items.stream()
                .map(item -> new TicketItemResponse(item.getId(), item.getDescription(), item.getPrice(), item.getQuantity()))
                .collect(Collectors.toList());
    }
}
