package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Addon.addonFiltered;
import br.fatec.easycoast.dtos.Products.productFiltered;

// ProductFiltered é uma classe que não tem o AddonCategory, porque é redundante, e vai dar loop. 
public record addonCategoryResponse(
                Integer id,
                String name,
                addonType type,
                productFiltered product,
                List<addonFiltered> addons) {

}
