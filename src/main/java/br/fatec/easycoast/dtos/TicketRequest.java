package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record TicketRequest(Integer checkoutId, LocalDateTime dateCreate, String client, Double totalValue) { }

