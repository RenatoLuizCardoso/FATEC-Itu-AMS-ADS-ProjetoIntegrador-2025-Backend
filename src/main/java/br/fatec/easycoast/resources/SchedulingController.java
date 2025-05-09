package br.fatec.easycoast.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.easycoast.dtos.scheduling.SchedulingRequest;
import br.fatec.easycoast.dtos.scheduling.SchedulingResponse;
import br.fatec.easycoast.services.SchedulingService;


@RestController
@RequestMapping("schedules")
public class SchedulingController {

    private final SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @GetMapping
    public ResponseEntity<List<SchedulingResponse>> getAll() {
        return ResponseEntity.ok(schedulingService.getSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingResponse> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(schedulingService.getScheduling(id));
    }

    @PostMapping
    public ResponseEntity<SchedulingResponse> create(@RequestBody SchedulingRequest request) {
        return ResponseEntity.ok(schedulingService.saveScheduling(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchedulingResponse> update(@PathVariable Integer id, @RequestBody SchedulingRequest request) {
        return ResponseEntity.ok(schedulingService.updateScheduling(id, request));
    }
}
