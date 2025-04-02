package br.fatec.easycoast.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    private String paymentForm;
    private double valuePaid;
    private double paymentChange;
    private String paymentStatus;

 
    public Integer getTicketId() {
        return ticket != null ? ticket.getId() : null;
    }

    
    public void setTicketId(Integer ticketId) {
        if (this.ticket == null) {
            this.ticket = new Ticket(); 
        }
        this.ticket.setId(ticketId); 
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public double getValuePaid() {
        return valuePaid;
    }

    public void setValuePaid(double valuePaid) {
        this.valuePaid = valuePaid;
    }

    public double getPaymentChange() {
        return paymentChange;
    }

    public void setPaymentChange(double paymentChange) {
        this.paymentChange = paymentChange;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
