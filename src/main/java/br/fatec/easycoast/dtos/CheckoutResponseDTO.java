package br.fatec.easycoast.dtos;

@Data
public class CheckoutResponseDTO {
    private Long id;
    private LocalDate dateOpened;
    private LocalTime timeOpened;
    private BigDecimal initialAmount;
    private String status;
}
