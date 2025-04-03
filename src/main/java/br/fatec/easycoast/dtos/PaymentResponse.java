package br.fatec.easycoast.dtos;

public record PaymentResponse(Integer id, Integer ticketId, String paymentForm, Double valuePaid, String paymentStatus) { }
