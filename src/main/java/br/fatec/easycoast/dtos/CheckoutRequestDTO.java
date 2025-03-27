package br.fatec.easycoast.dtos;

@Data
public class CheckoutRequestDTO {
    private LocalDate dateOpened;
    private LocalTime timeOpened;
    private BigDecimal initialAmount;
    private String status;
}
