package br.fatec.easycoast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.order.OrderRequest;
import br.fatec.easycoast.dtos.order.OrderResponse;
import br.fatec.easycoast.entities.Order;
import br.fatec.easycoast.entities.OrderItem;
import br.fatec.easycoast.mappers.OrderMapper;
import br.fatec.easycoast.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderResponse> getOrders() {
        List<OrderResponse> orderResponses = orderRepository.findAll()
                .stream()
                .map(order -> OrderMapper.toDTO(order))
                .toList();
        return orderResponses;
    }

    public OrderResponse getOrder(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order doesn't exist."));

        return OrderMapper.toDTO(order);
    }

    public OrderResponse saveOrder(OrderRequest request) {
        Order order = OrderMapper.toEntity(request);

        //Calculating the total, by the sum of the items' total
        double total = order.getOrderItems().stream().mapToDouble(OrderItem::getTotal).sum();
        order.setTotal(total);

        return OrderMapper.toDTO(orderRepository.save(order));
    }

    public OrderResponse updateOrder(Integer id, OrderRequest request) {
        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));

            // Atualiza os campos do pedido
            order.setOpeningTime(request.openingTime());
            order.setClosingTime(request.closingTime());
            order.setCard(request.card());
            order.setSeat(request.seat());
            order.setEmployee(request.employee());
            order.setOrderItems(request.orderItems());

            //Calculating the total, by the sum of the items' total
            double total = order.getOrderItems().stream().mapToDouble(OrderItem::getTotal).sum();
            order.setTotal(total);

            orderRepository.save(order);
            return OrderMapper.toDTO(order);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Order update failed.");
        }
    }
}
