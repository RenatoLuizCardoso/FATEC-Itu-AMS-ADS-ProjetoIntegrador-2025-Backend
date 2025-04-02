package br.fatec.easycoast.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CHECKOUT")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateOpening;
    private Double valueInitial;
    private String status; // "ABERTO" ou "FECHADO"

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateOpening() {
        return dateOpening;
    }

    public void setDateOpening(LocalDateTime dateOpening) {
        this.dateOpening = dateOpening;
    }

    public Double getValueInitial() {
        return valueInitial;
    }

    public void setValueInitial(Double valueInitial) {
        this.valueInitial = valueInitial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
