package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Products.productFiltered;
import br.fatec.easycoast.entities.Addon;

public record addonCategoryProductFiltered(
                Integer id,
                String name,
                addonType type,
                productFiltered product,
                List<Addon> addons) {

}
