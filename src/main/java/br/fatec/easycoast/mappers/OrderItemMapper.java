package br.fatec.easycoast.mappers;

import br.fatec.easycoast.dtos.orderItem.OrderItemRequest;
import br.fatec.easycoast.dtos.orderItem.OrderItemResponse;
import br.fatec.easycoast.entities.OrderItem;

public class OrderItemMapper {
    public static OrderItem toEntity(OrderItemRequest request) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(request.quantity());
        orderItem.setObservations(request.observations());
        orderItem.setTotal(request.total());
        orderItem.setProduct(request.product());
        orderItem.setAddons(request.addons());
        orderItem.setOrder(request.order());
        return orderItem;

    }

    public static OrderItemResponse toDTO(OrderItem orderItem) {

        return new OrderItemResponse(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getObservations(),
                orderItem.getTotal(),
                orderItem.getProduct(),
                orderItem.getAddons(),
                orderItem.getOrder());
    }

}
