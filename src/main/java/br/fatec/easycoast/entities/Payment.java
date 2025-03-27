package br.fatec.easycoast.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private String paymentMethod;
    private BigDecimal amountPaid;
    private BigDecimal change;
    private String status;

    // Getters e setters
}
