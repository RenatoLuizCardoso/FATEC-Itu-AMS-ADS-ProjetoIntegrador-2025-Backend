package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public class CheckoutRequest {
    private LocalDateTime dateOpening;
    private Double valueInitial;
    private String status;

    public LocalDateTime getDateOpening() { return dateOpening; }
    public void setDateOpening(LocalDateTime dateOpening) { this.dateOpening = dateOpening; }

    public Double getValueInitial() { return valueInitial; }
    public void setValueInitial(Double valueInitial) { this.valueInitial = valueInitial; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}