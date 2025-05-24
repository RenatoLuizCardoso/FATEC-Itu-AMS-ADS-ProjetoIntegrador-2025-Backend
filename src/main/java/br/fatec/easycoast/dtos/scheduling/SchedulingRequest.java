package br.fatec.easycoast.dtos.scheduling;

import java.time.Instant;

import br.fatec.easycoast.entities.Customer;
import br.fatec.easycoast.entities.Seat;

public record SchedulingRequest(
        Instant startsAt,
        Integer quantity,
        Seat seat,
        Customer customer

) {
}
