package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.entities.Addon;
import br.fatec.easycoast.entities.Product;
import br.fatec.easycoast.entities.resources.AddonType;

public record AddonCategoryResponse(
                Integer id,
                String name,
                AddonType type,
                Product product,
                List<Addon> addons) {

}
