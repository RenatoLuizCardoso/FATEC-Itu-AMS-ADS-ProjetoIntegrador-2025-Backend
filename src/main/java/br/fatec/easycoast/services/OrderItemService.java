package br.fatec.easycoast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.orderItem.OrderItemRequest;
import br.fatec.easycoast.dtos.orderItem.OrderItemResponse;
import br.fatec.easycoast.entities.Addon;
import br.fatec.easycoast.entities.OrderItem;
import br.fatec.easycoast.mappers.OrderItemMapper;
import br.fatec.easycoast.repositories.AddonRepository;
import br.fatec.easycoast.repositories.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddonRepository addonRepository;

    @Autowired
    private AddonService addonService;

    @Autowired
    private ProductService productService;

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

        List<Integer> addonIds = request.addons().stream().map(Addon::getId).toList();
        int addonNumber = addonRepository.findAddonIfexists(addonIds, request.product().getId());
        if (addonNumber > 0) {
            throw new EntityNotFoundException("Addon incorrect");
        } else {
            OrderItem orderItem = OrderItemMapper.toEntity(request);

            // Calculating the total, by the sum of the price of the addons, and multipling
            // the price of the product with the quantity
            double total = orderItem.getAddons().stream()
                    .mapToDouble(addon -> addonService.getAddonById(addon.getId()).price()).sum();
            
            
            total += productService.getProductById(orderItem.getProduct().getId()).price() * orderItem.getQuantity();
            orderItem.setTotal(total);

            return OrderItemMapper.toDTO(orderItemRepository.save(orderItem), true);

        }

    }

    public void updateOrderItem(Integer id, OrderItemRequest request) {

        List<Integer> addonIds = request.addons().stream().map(Addon::getId).toList();
        int addonNumber = addonRepository.findAddonIfexists(addonIds, request.product().getId());
        if (addonNumber > 0) {
            throw new EntityNotFoundException("Addon incorrect");
        } else {

            try {
                OrderItem orderItem = orderItemRepository.getReferenceById(id);
                orderItem.setQuantity(request.quantity());
                orderItem.setObservations(request.observations());
                orderItem.setProduct(request.product());
                orderItem.setAddons(request.addons());
                orderItem.setOrder(request.order());

                double total = orderItem.getAddons().stream().mapToDouble(Addon::getPrice).sum();
                total += orderItem.getProduct().getPrice() * orderItem.getQuantity();
                orderItem.setTotal(total);

                orderItemRepository.save(orderItem);

            } catch (EntityNotFoundException e) {
                throw new EntityNotFoundException("Not found Order Item.");
            }

        }

    }

}