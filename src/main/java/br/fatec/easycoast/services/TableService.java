package br.fatec.easycoast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.entities.Seat;
import br.fatec.easycoast.repositories.TableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<Seat> getTables() {
        return tableRepository.findAll();
    }

    public Optional<Seat> getTable(Integer id) {
        return tableRepository.findById(id);
    }

    public Seat saveTable(Seat table) {
        return tableRepository.save(table);
    }

    public Seat updateTable(Integer id, Seat tableDetails) {
        Seat table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada com ID: " + id));

        // Atualiza os campos da mesa
        table.setStatus(tableDetails.getStatus());

        return tableRepository.save(table);
    }
}
