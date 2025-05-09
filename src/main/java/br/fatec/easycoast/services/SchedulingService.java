package br.fatec.easycoast.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.scheduling.SchedulingRequest;
import br.fatec.easycoast.dtos.scheduling.SchedulingResponse;
import br.fatec.easycoast.entities.Customer;
import br.fatec.easycoast.entities.Scheduling;
import br.fatec.easycoast.repositories.CustomerRepository;
import br.fatec.easycoast.repositories.SchedulingRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    // private final SeatRepository seatRepository; // Comentado, aguardando implementação do Seat
    private final CustomerRepository customerRepository;

    public SchedulingService(SchedulingRepository schedulingRepository, /* SeatRepository seatRepository, */ CustomerRepository customerRepository) {
        this.schedulingRepository = schedulingRepository;
        // this.seatRepository = seatRepository; // Comentado, aguardando implementação do Seat
        this.customerRepository = customerRepository;
    }

    public List<SchedulingResponse> getSchedules() {
        return schedulingRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public SchedulingResponse getScheduling(Integer id) {
        Scheduling scheduling = schedulingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        return toResponse(scheduling);
    }

    public SchedulingResponse saveScheduling(SchedulingRequest request) {
        Scheduling scheduling = new Scheduling();
        return persistScheduling(scheduling, request);
    }

    public SchedulingResponse updateScheduling(Integer id, SchedulingRequest request) {
        Scheduling scheduling = schedulingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        return persistScheduling(scheduling, request);
    }

    private SchedulingResponse persistScheduling(Scheduling scheduling, SchedulingRequest request) {
        scheduling.setStartsAt(request.getStartsAt());
        scheduling.setQuantity(request.getQuantity());

        // Parte comentada, aguardando implementação do Seat
        // Seat seat = seatRepository.findById(request.getSeatId()).orElseThrow(() -> new EntityNotFoundException("Assento não encontrado"));
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        // scheduling.setSeat(seat); // Comentado, aguardando implementação do Seat
        scheduling.setCustomer(customer);

        Scheduling saved = schedulingRepository.save(scheduling);
        return toResponse(saved);
    }

    private SchedulingResponse toResponse(Scheduling scheduling) {
        SchedulingResponse response = new SchedulingResponse();
        response.setId(scheduling.getId());
        response.setStartsAt(scheduling.getStartsAt());
        response.setQuantity(scheduling.getQuantity());
        
        // Parte comentada, aguardando implementação do Seat
        // response.setSeatName(scheduling.getSeat().getName()); // Comentado, aguardando implementação do Seat
        
        response.setCustomerName(scheduling.getCustomer().getName());
        return response;
    }
}