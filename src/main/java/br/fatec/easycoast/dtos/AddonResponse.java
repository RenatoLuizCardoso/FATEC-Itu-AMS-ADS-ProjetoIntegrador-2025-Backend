package br.fatec.easycoast.dtos;

import br.fatec.easycoast.dtos.Products.ProductResponse;

public record AddonResponse(
        Integer id,
        String name,
        Float price,
        Boolean availability,
        ProductResponse product,
        ItemResponse item) {
}