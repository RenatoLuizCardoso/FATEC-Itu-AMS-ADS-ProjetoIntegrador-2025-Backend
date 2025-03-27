package br.fatec.easycoast.dtos;

@Data
public class TicketRequestDTO {
    private Long checkoutId; // Referência para o caixa
    private String status; 
    private LocalDateTime creationDate;
    private String client;
    private BigDecimal totalAmount;
}
