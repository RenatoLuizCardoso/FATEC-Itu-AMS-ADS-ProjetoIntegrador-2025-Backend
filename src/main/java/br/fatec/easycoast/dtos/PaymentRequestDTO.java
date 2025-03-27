package br.fatec.easycoast.dtos;

@Data
public class PaymentResponseDTO {
    private Long id;
    private Long ticketId;
    private String paymentMethod;
    private BigDecimal amountPaid;
    private BigDecimal change;
    private String status;
}
