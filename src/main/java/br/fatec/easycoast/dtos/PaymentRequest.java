package br.fatec.easycoast.dtos;

public record PaymentRequest(Integer ticketId, String paymentForm, Double valuePaid) { }
