package br.fatec.easycoast.dtos.order;

import java.sql.Timestamp;
import java.util.List;

public class OrderResponse {
    private Integer id;
    private Timestamp openingTime;
    private Timestamp closingTime;
    private Double total;
    private Card card;
    private Table table;
    private Employee employee;
    private List<OrderItem> orderItems;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Timestamp openingTime) {
        this.openingTime = openingTime;
    }

    public Timestamp getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Timestamp closingTime) {
        this.closingTime = closingTime;
    }

    public Double getTotal() {
        return total;
    }
}
   