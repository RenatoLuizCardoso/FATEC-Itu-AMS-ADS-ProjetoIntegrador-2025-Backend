package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record CheckoutResponse(Integer id, LocalDateTime dateOpening, Double valueInitial, String status) { }

