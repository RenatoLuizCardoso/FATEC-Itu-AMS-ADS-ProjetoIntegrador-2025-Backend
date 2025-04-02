package br.fatec.easycoast.resources;


import br.fatec.easycoast.dtos.PaymentRequest;
import br.fatec.easycoast.dtos.PaymentResponse;
import br.fatec.easycoast.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<PaymentResponse>> getPaymentsByTicket(@PathVariable Integer ticketId) {
        List<PaymentResponse> payments = paymentService.getPaymentsByTicket(ticketId);
        return ResponseEntity.ok(payments);
    }
}

