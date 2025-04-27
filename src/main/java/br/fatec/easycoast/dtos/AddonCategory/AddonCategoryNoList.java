package br.fatec.easycoast.dtos.AddonCategory;

import br.fatec.easycoast.dtos.Products.productFiltered;

public record addonCategoryNoList(
                Integer id,
                String name,
                addonType type,
                productFiltered product) {

}