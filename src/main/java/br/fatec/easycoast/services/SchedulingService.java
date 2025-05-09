package br.fatec.easycoast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import br.fatec.easycoast.dtos.scheduling.SchedulingRequest;
import br.fatec.easycoast.dtos.scheduling.SchedulingResponse;
import br.fatec.easycoast.entities.Customer;
import br.fatec.easycoast.entities.Scheduling;
import br.fatec.easycoast.repositories.CustomerRepository;
import br.fatec.easycoast.repositories.SchedulingRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SchedulingService {

    @Autowired
    private final SchedulingRepository schedulingRepository;
    private final CustomerRepository customerRepository;

    public SchedulingService(SchedulingRepository schedulingRepository, CustomerRepository customerRepository) {
        this.schedulingRepository = schedulingRepository;
        this.customerRepository = customerRepository;
    }

    public List<SchedulingResponse> getSchedules() {
        return schedulingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public SchedulingResponse getScheduling(Integer id) {
        Scheduling scheduling = schedulingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        return toResponse(scheduling);
    }

    public SchedulingResponse saveScheduling(SchedulingRequest request) {
        try {
            return persistScheduling(new Scheduling(), request);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
    }

    public SchedulingResponse updateScheduling(Integer id, SchedulingRequest request) {
        Scheduling scheduling = schedulingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        return persistScheduling(scheduling, request);
    }

    private SchedulingResponse persistScheduling(Scheduling scheduling, SchedulingRequest request) {
        scheduling.setStartsAt(request.startsAt());
        scheduling.setQuantity(request.quantity());

        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        scheduling.setCustomer(customer);

        Scheduling saved = schedulingRepository.save(scheduling);

        return toResponse(saved);
    }

    private SchedulingResponse toResponse(Scheduling scheduling) {
        return new SchedulingResponse(
            scheduling.getId(),
            scheduling.getStartsAt(),
            scheduling.getQuantity(),
            scheduling.getCustomer().getName() 
        );
    }
}
