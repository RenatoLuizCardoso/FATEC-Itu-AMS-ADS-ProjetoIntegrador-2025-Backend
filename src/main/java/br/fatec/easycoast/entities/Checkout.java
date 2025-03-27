package br.fatec.easycoast.entities;

@Entity
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataAbertura;

    @Column(nullable = false)
    private LocalTime horaAbertura;

    @Column(nullable = false)
    private BigDecimal valorInicial;

    @Column(nullable = false)
    private String status;

    // Getters and Setters
}
