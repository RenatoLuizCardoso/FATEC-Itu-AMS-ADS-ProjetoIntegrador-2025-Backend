package br.fatec.easycoast.entities;

import jakarta.persistence.*;
import java.sql.Timestamp;
//import java.util.List;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Instant openingTime;
    private Instant closingTime;
    private Double total;

    // @ManyToOne
    // private Card card;

    @ManyToOne
    private Table table;

    // @ManyToOne
    // private Employee employee;

    // @OneToMany(mappedBy = "order")
    // private List<OrderItem> orderItems;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Instant openingTime) {
        this.openingTime = openingTime;
    }

    public Instant getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Instant closingTime) {
        this.closingTime = closingTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    // public Card getCard() {
    // return card;
    // }

    /*
     * public void setCard(Card card) {
     * this.card = card;
     * }
     */

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    /*
     * public Employee getEmployee() {
     * return employee;
     * }
     * 
     * public void setEmployee(Employee employee) {
     * this.employee = employee;
     * }
     * 
     * public List<OrderItem> getOrderItems() {
     * return orderItems;
     * }
     * 
     * public void setOrderItems(List<OrderItem> orderItems) {
     * this.orderItems = orderItems;
     * }
     */
}