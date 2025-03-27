package br.fatec.easycoast.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Endpoint para criar pagamento
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO response = paymentService.createPayment(paymentRequestDTO);
        return ResponseEntity.ok(response);
    }

    // Endpoint para buscar pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable Long id) {
        PaymentResponseDTO response = paymentService.getPaymentById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para buscar todos os pagamentos
    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        List<PaymentResponseDTO> responses = paymentService.getAllPayments();
        return ResponseEntity.ok(responses);
    }
}

