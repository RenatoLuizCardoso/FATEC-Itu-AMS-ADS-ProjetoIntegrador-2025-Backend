package br.fatec.easycoast.dtos.payment;

import java.time.LocalDateTime;

public record PaymentResponse(
    Integer id,
    Double value,
    PaymentMethod methodPayment,
    LocalDateTime date,
    PaymentStatus status,
    Integer orderId
) {}