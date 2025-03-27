package br.fatec.easycoast.entities;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "checkout_id", nullable = false)
    private Checkout checkout;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    private String cliente;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    // Getters and Setters
}
