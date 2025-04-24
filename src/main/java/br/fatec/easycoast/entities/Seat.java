package br.fatec.easycoast.entities;

import br.fatec.easycoast.dtos.table.TableStatus;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_SEAT")
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
}