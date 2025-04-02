package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public class CheckoutResponse {
    private Integer id;
    private LocalDateTime dateOpening;
    private Double valueInitial;
    private String status;

    public CheckoutResponse(Integer id, LocalDateTime dateOpening, Double valueInitial, String status) {
        this.id = id;
        this.dateOpening = dateOpening;
        this.valueInitial = valueInitial;
        this.status = status;
    }

    public Integer getId() { return id; }
    public LocalDateTime getDateOpening() { return dateOpening; }
    public Double getValueInitial() { return valueInitial; }
    public String getStatus() { return status; }
}
