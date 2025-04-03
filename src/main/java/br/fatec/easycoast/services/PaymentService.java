package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.PaymentRequest;
import br.fatec.easycoast.dtos.PaymentResponse;
import br.fatec.easycoast.entities.Payment;
import br.fatec.easycoast.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest request) {
        
        Payment payment = new Payment();
        payment.setTicketId(request.ticketId());  
        payment.setPaymentForm(request.paymentForm());  
        payment.setValuePaid(request.valuePaid());  
        payment.setPaymentStatus("Completed");

        Payment saved = paymentRepository.save(payment);

        return new PaymentResponse(saved.getId(), saved.getTicketId(), saved.getPaymentForm(), saved.getValuePaid(), saved.getPaymentStatus());
    }

    public List<PaymentResponse> getPaymentsByTicket(Integer ticketId) {
        return paymentRepository.findByTicketId(ticketId).stream()
                .map(payment -> new PaymentResponse(payment.getId(), payment.getTicketId(), payment.getPaymentForm(), payment.getValuePaid(), payment.getPaymentStatus()))
                .collect(Collectors.toList());
    }
}

