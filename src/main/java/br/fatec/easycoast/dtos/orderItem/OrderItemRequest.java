package br.fatec.easycoast.dtos.orderItem;

import java.util.List;

public class OrderItemRequest {
    private Integer quantity;
    private String observations;
    private Double total;
    private Integer productId;
    private List<Integer> addonIds;
    private Integer orderId;

    // Getters e Setters
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Integer> getAddonIds() {
        return addonIds;
    }

    public void setAddonIds(List<Integer> addonIds) {
        this.addonIds = addonIds;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}

