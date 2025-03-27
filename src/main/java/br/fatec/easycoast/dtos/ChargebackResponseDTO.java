package br.fatec.easycoast.dtos;

@Data
public class ChargebackResponseDTO {
    private Long id;
    private Long ticketId;
    private Long ticketItemId;
    private String reason;
    private LocalDateTime chargebackDate;
}
