package br.fatec.easycoast.dtos.payment;

import java.time.Instant;

public record PaymentResponse(
    Integer id,
    Double value,
    PaymentMethod methodPayment,
    Instant date,
    PaymentStatus status,
    Integer orderId
) {}
