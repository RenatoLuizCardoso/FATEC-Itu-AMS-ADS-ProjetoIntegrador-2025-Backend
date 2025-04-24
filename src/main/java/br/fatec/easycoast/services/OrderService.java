package br.fatec.easycoast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.entities.Order;
import br.fatec.easycoast.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));

        // Atualiza os campos do pedido
        order.setOpeningTime(orderDetails.getOpeningTime());
        order.setClosingTime(orderDetails.getClosingTime());
        order.setTotal(orderDetails.getTotal());
        //order.setCard(orderDetails.getCard());
        order.setTable(orderDetails.getTable());
        //order.setEmployee(orderDetails.getEmployee());
        //order.setOrderItems(orderDetails.getOrderItems());

        return orderRepository.save(order);
    }
}
