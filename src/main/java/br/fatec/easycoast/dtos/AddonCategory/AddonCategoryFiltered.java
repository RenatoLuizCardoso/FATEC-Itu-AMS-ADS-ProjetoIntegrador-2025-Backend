package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Addon.addonFiltered;
import br.fatec.easycoast.dtos.Products.productFiltered;

public record addonCategoryFiltered(
                Integer id,
                String name,
                addonType type,
                productFiltered product,
                List<addonFiltered> addons) {

}
