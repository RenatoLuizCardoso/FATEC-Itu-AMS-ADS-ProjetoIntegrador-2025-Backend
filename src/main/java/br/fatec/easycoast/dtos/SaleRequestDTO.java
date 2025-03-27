package br.fatec.easycoast.dtos;

@Data
public class SaleRequestDTO {
    private Long ticketId;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private String invoiceNumber;
}
