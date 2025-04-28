package br.fatec.easycoast.dtos.product;

import java.util.List;

import br.fatec.easycoast.dtos.item.ItemResponse;

// classe AddonCategory retirado para não ficar redundante. 
public record ProductFiltered(
                Integer id,
                String name,
                String description,
                Float price,
                Float discount,
                Boolean availability,
                String category,
                String imageurl,
                List<ItemResponse> items

) {
}
