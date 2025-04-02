package br.fatec.easycoast.dtos;

public class PaymentRequest {
    private Integer ticketId;
    private String paymentForm;
    private Double valuePaid;

    public Integer getTicketId() { return ticketId; }
    public void setTicketId(Integer ticketId) { this.ticketId = ticketId; }

    public String getPaymentForm() { return paymentForm; }
    public void setPaymentForm(String paymentForm) { this.paymentForm = paymentForm; }

    public Double getValuePaid() { return valuePaid; }
    public void setValuePaid(Double valuePaid) { this.valuePaid = valuePaid; }
}