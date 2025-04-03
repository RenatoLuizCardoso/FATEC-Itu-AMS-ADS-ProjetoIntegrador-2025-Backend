package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record ChargebackRequest(
    Long ticketId,       
    String motive,
    LocalDateTime chargebackDate
) {}

