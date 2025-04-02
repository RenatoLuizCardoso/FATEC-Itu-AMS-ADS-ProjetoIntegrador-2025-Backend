package br.fatec.easycoast.dtos;


public class PaymentResponse {
    private Integer id;
    private Integer ticketId;
    private String paymentForm;
    private Double valuePaid;
    private String paymentStatus;

    public PaymentResponse(Integer id, Integer ticketId, String paymentForm, Double valuePaid, String paymentStatus) {
        this.id = id;
        this.ticketId = ticketId;
        this.paymentForm = paymentForm;
        this.valuePaid = valuePaid;
        this.paymentStatus = paymentStatus;
    }

    public Integer getId() { return id; }
    public Integer getTicketId() { return ticketId; }
    public String getPaymentForm() { return paymentForm; }
    public Double getValuePaid() { return valuePaid; }
    public String getPaymentStatus() { return paymentStatus; }
}
