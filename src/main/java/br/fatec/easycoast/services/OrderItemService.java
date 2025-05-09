package br.fatec.easycoast.services;

import java.util.List;

import br.fatec.easycoast.dtos.orderItem.OrderItemRequest;
import br.fatec.easycoast.dtos.orderItem.OrderItemResponse;

public interface OrderItemService {
    List<OrderItemResponse> getOrderItems(Integer orderId);
    OrderItemResponse getOrderItem(Integer id);
    OrderItemResponse saveOrderItem(OrderItemRequest request);
    OrderItemResponse updateOrderItem(Integer id, OrderItemRequest request);
}

