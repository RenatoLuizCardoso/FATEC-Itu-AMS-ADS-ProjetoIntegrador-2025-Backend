package br.fatec.easycoast.dtos.AddonCategory;

import br.fatec.easycoast.dtos.Products.ProductFiltered;
import br.fatec.easycoast.entities.resources.AddonType;

public record AddonCategoryNoList(
        Integer id,
        String name,
        AddonType type,
        ProductFiltered product) {

}