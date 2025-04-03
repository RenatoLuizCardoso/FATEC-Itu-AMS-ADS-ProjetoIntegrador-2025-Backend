package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record CheckoutRequest(LocalDateTime dateOpening, Double valueInitial, String status) { }
