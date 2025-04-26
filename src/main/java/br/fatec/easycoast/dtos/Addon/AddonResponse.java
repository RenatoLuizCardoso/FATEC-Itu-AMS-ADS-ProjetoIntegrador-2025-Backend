package br.fatec.easycoast.dtos.Addon;

import br.fatec.easycoast.dtos.ItemResponse;
import br.fatec.easycoast.dtos.Products.ProductResponse;

public record AddonResponse(
        Integer id,
        String name,
        Float price,
        Boolean availability,
        ProductResponse product,
        ItemResponse item) {
}