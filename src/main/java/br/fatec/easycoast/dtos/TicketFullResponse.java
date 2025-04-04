package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record TicketFullResponse(
    Integer id,
    Integer checkoutId,
    LocalDateTime dateCreate,
    String client,
    Double totalValue,
    List<TicketItemResponse> ticketItems
) {}
