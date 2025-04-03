package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record ChargebackResponse(
        Integer id,
        Integer ticketId,
        String motive,
        LocalDateTime chargebackDate
) { }
