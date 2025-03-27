package br.fatec.easycoast.dtos;

@Data
public class ChargebackRequestDTO {
    private Long ticketId;
    private Long ticketItemId;
    private String reason;
    private LocalDateTime chargebackDate;
}