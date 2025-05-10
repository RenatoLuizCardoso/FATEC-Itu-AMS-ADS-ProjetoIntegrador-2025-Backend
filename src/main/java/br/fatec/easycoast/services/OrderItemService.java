package br.fatec.easycoast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.orderItem.OrderItemRequest;
import br.fatec.easycoast.dtos.orderItem.OrderItemResponse;
import br.fatec.easycoast.entities.OrderItem;
import br.fatec.easycoast.mappers.OrderItemMapper;
import br.fatec.easycoast.repositories.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItemResponse> getOrderItems() {
        List<OrderItemResponse> orderItemsResponse = orderItemRepository
                .findAll()
                .stream()
                .map(orderItem -> OrderItemMapper.toDTO(orderItem))
                .toList();
        return orderItemsResponse;

    }

    public OrderItemResponse getOrderItem(Integer id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Order Item not found"));
        return OrderItemMapper.toDTO(orderItem);
    }

    public OrderItemResponse saveOrderItem(OrderItemRequest request) {
        OrderItem orderItem = orderItemRepository.save(OrderItemMapper.toEntity(request));
        return OrderItemMapper.toDTO(orderItem);
    }

    public void updateOrderItem(Integer id, OrderItemRequest request) {
        try {
            OrderItem orderItem = orderItemRepository.getReferenceById(id);
            orderItem.setQuantity(request.quantity());
            orderItem.setObservations(request.observations());
            orderItem.setTotal(request.total());
            orderItem.setProduct(request.product());
            orderItem.setAddons(request.addons());
            orderItem.setOrder(request.order());
            orderItemRepository.save(orderItem);

        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Not found Order Item.");
        }

    }

}