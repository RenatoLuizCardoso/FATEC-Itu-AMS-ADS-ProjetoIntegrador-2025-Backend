package br.fatec.easycoast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    // Criar pagamento
    @Transactional
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = paymentMapper.toEntity(paymentRequestDTO);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toResponseDTO(savedPayment);
    }

    // Obter pagamento por ID
    public PaymentResponseDTO getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            return paymentMapper.toResponseDTO(payment.get());
        } else {
            // Retornar algum erro ou resposta nula
            return null;
        }
    }

    // Obter todos os pagamentos
    public List<PaymentResponseDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return paymentMapper.toResponseDTOList(payments);
    }
}
