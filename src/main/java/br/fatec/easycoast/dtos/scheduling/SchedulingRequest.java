package br.fatec.easycoast.dtos.scheduling;

import java.sql.Timestamp;


public class SchedulingRequest {
    private Timestamp startsAt;
    private Integer quantity;
    private Integer seatId; // Comentado até implementação do Seat
    private Integer customerId;

    // Getters e Setters
    public Timestamp getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Timestamp startsAt) {
        this.startsAt = startsAt;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSeatId() { // Comentado até implementação do Seat
        return seatId;
    }

    public void setSeatId(Integer seatId) { // Comentado até implementação do Seat
        this.seatId = seatId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}