package br.fatec.easycoast.dtos.orderItem;

import br.fatec.easycoast.dtos.product.ProductResponse;

public class OrderItemResponse {
    private Integer id;
    private Integer quantity;
    private String observations;
    private Double total;
    private ProductResponse product;
    //private List<AddonResponse> addons;
    private Integer orderId;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }

    /*public List<AddonResponse> getAddons() {
        return addons;
    }

    public void setAddons(List<AddonResponse> addons) {
        this.addons = addons;
    }*/

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}

