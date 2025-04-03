package br.fatec.easycoast.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "checkout_id")
    private Checkout checkout;

    private LocalDateTime dateCreate;
    private String client;
    private Double totalValue;

    @OneToMany(mappedBy = "ticket")
    private List<TicketItem> ticketItems; // Relacionamento com TicketItem

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<TicketItem> getTicketItems() {
        return ticketItems;
    }

    public void setTicketItems(List<TicketItem> ticketItems) {
        this.ticketItems = ticketItems;
    }
}
