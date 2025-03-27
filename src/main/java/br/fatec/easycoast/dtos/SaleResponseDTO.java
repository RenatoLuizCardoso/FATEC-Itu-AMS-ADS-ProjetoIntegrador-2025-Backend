package br.fatec.easycoast.dtos;

@Data
public class SaleResponseDTO {
    private Long id;
    private Long ticketId;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private String invoiceNumber;
}