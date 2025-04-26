package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Products.ProductFiltered;
import br.fatec.easycoast.entities.Addon;
import br.fatec.easycoast.entities.resources.AddonType;

// ProductFiltered é uma classe que não tem o AddonCategory, porque é redundante, e vai dar loop. 
public record AddonCategoryResponse(
                Integer id,
                String name,
                AddonType type,
                ProductFiltered product,
                List<Addon> addons) {

}
