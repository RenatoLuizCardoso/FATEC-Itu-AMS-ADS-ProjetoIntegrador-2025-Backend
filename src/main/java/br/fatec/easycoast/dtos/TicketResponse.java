package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record TicketResponse(Integer id, Integer checkoutId, LocalDateTime dateCreate, String client, Double totalValue) { }
