package br.fatec.easycoast.dtos.payment;

import java.time.Instant;

public record PaymentRequest(
    Double value,
    PaymentMethod methodPayment,
    Instant date,
    PaymentStatus status,
    Integer orderId
) {}

