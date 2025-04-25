package br.fatec.easycoast.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.easycoast.dtos.seat.SeatRequest;
import br.fatec.easycoast.dtos.seat.SeatResponse;
import br.fatec.easycoast.dtos.seat.SeatStatus;
import br.fatec.easycoast.entities.Seat;
import br.fatec.easycoast.services.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<SeatResponse> getSeats() {
        return seatService.getSeats().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatResponse> getSeat(@PathVariable Integer id) {
        return seatService.getSeat(id)
                .map(seat -> ResponseEntity.ok(convertToResponse(seat)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SeatResponse saveSeat(@RequestBody SeatRequest seatRequest) {
        Seat seat = new Seat();
        seat.setStatus(seatRequest.getStatus());
        return convertToResponse(seatService.saveSeat(seat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatResponse> updateSeat(@PathVariable Integer id, @RequestBody SeatRequest seatRequest) {
        Seat seat = new Seat();
        seat.setStatus(seatRequest.getStatus());
        return ResponseEntity.ok(convertToResponse(seatService.updateSeat(id, seat)));
    }

    // Métodos de conversão
    private SeatResponse convertToResponse(Seat seat) {
        SeatResponse response = new SeatResponse();
        response.setId(seat.getId());
        response.setStatus((SeatStatus) seat.getStatus());
        return response;
    }
}
