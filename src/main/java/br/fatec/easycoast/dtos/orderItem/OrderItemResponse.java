package br.fatec.easycoast.dtos.orderItem;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.fatec.easycoast.entities.Addon;
import br.fatec.easycoast.entities.Order;
import br.fatec.easycoast.entities.Product;

public record OrderItemResponse(
                Integer id,
                Integer quantity,
                String observations,
                Double total,
                Product product,
                @JsonIgnoreProperties("product") List<Addon> addons,
                Order order) {
}