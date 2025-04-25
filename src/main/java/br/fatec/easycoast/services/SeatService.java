package br.fatec.easycoast.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.entities.Seat;
import br.fatec.easycoast.repositories.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeat(Integer id) {
        return seatRepository.findById(id);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Integer id, Seat seatDetails) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assento não encontrado com ID: " + id));

        // Atualiza os campos do assento
        seat.setStatus(seatDetails.getStatus());

        return seatRepository.save(seat);
    }
}
