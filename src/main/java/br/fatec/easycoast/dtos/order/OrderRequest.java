package br.fatec.easycoast.dtos.order;

import java.sql.Timestamp;
import java.util.List;

public class OrderRequest {
    private Timestamp openingTime;
    private Timestamp closingTime;
    private Double total;
    private Integer cardId; 
    private Integer tableId; 
    private Integer employeeId; 
    private List<Integer> orderItemIds; 

    // Getters and Setters
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

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getOrderItemIds() {
        return orderItemIds;
    }

    public void setOrderItemIds(List<Integer> orderItemIds) {
        this.orderItemIds = orderItemIds;
    }
}