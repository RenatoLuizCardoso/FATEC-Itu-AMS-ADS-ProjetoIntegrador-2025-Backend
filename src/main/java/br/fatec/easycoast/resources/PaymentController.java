package br.fatec.easycoast.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.fatec.easycoast.dtos.payment.PaymentRequest;
import br.fatec.easycoast.dtos.payment.PaymentResponse;
import br.fatec.easycoast.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService PaymentService;

    public PaymentController(PaymentService paymentService) {
        this.PaymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAllPayments() {
        return ResponseEntity.ok(PaymentService.getPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable Integer id) {
        return ResponseEntity.ok(PaymentService.getPayment(id));
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(PaymentService.savePayment(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable Integer id, @RequestBody PaymentRequest request) {
        return ResponseEntity.ok(PaymentService.updatePayment(id, request));
    }
}