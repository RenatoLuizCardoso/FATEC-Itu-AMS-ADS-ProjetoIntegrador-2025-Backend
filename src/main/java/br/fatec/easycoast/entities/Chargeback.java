package br.fatec.easycoast.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Chargeback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket; 

    private String motive; 

    @Column(name = "chargeback_date")
    private LocalDateTime chargebackDate; 

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public LocalDateTime getChargebackDate() {
        return chargebackDate;
    }

    public void setChargebackDate(LocalDateTime chargebackDate) {
        this.chargebackDate = chargebackDate;
    }
}
