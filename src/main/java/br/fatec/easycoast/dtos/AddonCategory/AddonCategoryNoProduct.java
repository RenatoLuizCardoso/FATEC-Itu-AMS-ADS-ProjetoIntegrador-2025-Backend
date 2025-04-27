package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Addon.AddonFiltered;
import br.fatec.easycoast.entities.resources.AddonType;

public record AddonCategoryNoProduct(
        Integer id,
        String name,
        AddonType type,
        List<AddonFiltered> addons

) {

}