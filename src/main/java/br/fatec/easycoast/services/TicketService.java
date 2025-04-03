package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.TicketRequest;
import br.fatec.easycoast.dtos.TicketResponse;
import br.fatec.easycoast.entities.Ticket;
import br.fatec.easycoast.entities.Checkout;
import br.fatec.easycoast.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    
    public List<TicketResponse> findAll() {
        return ticketRepository.findAll().stream()
                .map(ticket -> new TicketResponse(
                        ticket.getId(),
                        ticket.getCheckout().getId(), 
                        ticket.getDateCreate(),
                        ticket.getClient(),
                        ticket.getTotalValue()
                ))
                .collect(Collectors.toList());
    }

   
    public Optional<TicketResponse> findById(Integer id) {
        return ticketRepository.findById(id)
                .map(ticket -> new TicketResponse(
                        ticket.getId(),
                        ticket.getCheckout().getId(), 
                        ticket.getDateCreate(),
                        ticket.getClient(),
                        ticket.getTotalValue()
                ));
    }

    
    public TicketResponse save(TicketRequest request) {
        Ticket ticket = new Ticket();
        
        ticket.setCheckout(new Checkout()); 
        ticket.setDateCreate(request.dateCreate());
        ticket.setClient(request.client());
        ticket.setTotalValue(request.totalValue());

        
        Ticket savedTicket = ticketRepository.save(ticket);

        
        return new TicketResponse(
                savedTicket.getId(),
                savedTicket.getCheckout().getId(), 
                savedTicket.getDateCreate(),
                savedTicket.getClient(),
                savedTicket.getTotalValue()
        );
    }
}
