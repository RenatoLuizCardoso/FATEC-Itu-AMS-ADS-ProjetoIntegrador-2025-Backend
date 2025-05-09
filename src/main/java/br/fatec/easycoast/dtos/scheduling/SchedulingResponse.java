package br.fatec.easycoast.dtos.scheduling;

import java.sql.Timestamp;

public class SchedulingResponse {
    private Integer id;
    private Timestamp startsAt;
    private Integer quantity;
    private String seatName; // Comentado até implementação do Seat
    private String customerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getSeatName() { // Comentado até implementação do Seat
        return seatName;
    }

    public void setSeatName(String seatName) { // Comentado até implementação do Seat
        this.seatName = seatName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}