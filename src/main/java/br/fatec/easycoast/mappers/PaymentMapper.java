package br.fatec.easycoast.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    // Converte PaymentRequestDTO para Payment
    Payment toEntity(PaymentRequestDTO paymentRequestDTO);

    // Converte Payment para PaymentResponseDTO
    PaymentResponseDTO toResponseDTO(Payment payment);

    // Converte lista de Payment para lista de PaymentResponseDTO
    List<PaymentResponseDTO> toResponseDTOList(List<Payment> payments);
}