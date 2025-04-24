package br.fatec.easycoast.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.fatec.easycoast.dtos.seat.TableRequest;
import br.fatec.easycoast.dtos.seat.TableResponse;
import br.fatec.easycoast.entities.Seat;
import br.fatec.easycoast.services.TableService;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<TableResponse> getTables() {
        return tableService.getTables().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableResponse> getTable(@PathVariable Integer id) {
        return tableService.getTable(id)
                .map(table -> ResponseEntity.ok(convertToResponse(table)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TableResponse saveTable(@RequestBody TableRequest tableRequest) {
        Table table = new Table();
        table.setStatus(tableRequest.getStatus());
        return convertToResponse(tableService.saveTable(table));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableResponse> updateTable(@PathVariable Integer id, @RequestBody TableRequest tableRequest) {
        Table table = new Table();
        table.setStatus(tableRequest.getStatus());
        return ResponseEntity.ok(convertToResponse(tableService.updateTable(id, table)));
    }

    // Métodos de conversão
    private TableResponse convertToResponse(Table table) {
        TableResponse response = new TableResponse();
        response.setId(table.getId());
        response;
    }
