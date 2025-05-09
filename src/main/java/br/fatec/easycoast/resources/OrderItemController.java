package br.fatec.easycoast.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.easycoast.dtos.orderItem.OrderItemRequest;
import br.fatec.easycoast.dtos.orderItem.OrderItemResponse;
import br.fatec.easycoast.services.OrderItemService;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItemResponse> getOrderItems(@PathVariable Integer orderId) {
        return orderItemService.getOrderItems(orderId);
    }

    @GetMapping("/{id}")
    public OrderItemResponse getOrderItem(@PathVariable Integer id) {
        return orderItemService.getOrderItem(id);
    }

    @PostMapping
    public OrderItemResponse saveOrderItem(@RequestBody OrderItemRequest request) {
        return orderItemService.saveOrderItem(request);
    }

    @PutMapping("/{id}")
    public OrderItemResponse updateOrderItem(@PathVariable Integer id, @RequestBody OrderItemRequest request) {
        return orderItemService.updateOrderItem(id, request);
    }
}

