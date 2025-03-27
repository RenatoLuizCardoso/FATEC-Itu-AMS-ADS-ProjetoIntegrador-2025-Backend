package br.fatec.easycoast.dtos;

@Data
public class TicketResponseDTO {
    private Long id;
    private Long checkoutId; // Referência para o caixa
    private String status;
    private LocalDateTime creationDate;
    private String client;
    private BigDecimal totalAmount;
}
