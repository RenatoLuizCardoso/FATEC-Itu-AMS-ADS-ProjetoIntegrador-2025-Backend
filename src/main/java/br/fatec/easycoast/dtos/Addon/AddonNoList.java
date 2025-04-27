package br.fatec.easycoast.dtos.Addon;

import br.fatec.easycoast.dtos.ItemResponse;
import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryNoList;

public record AddonNoList(
        Integer id,
        String name,
        Float price,
        Boolean availability,
        ItemResponse item,
        AddonCategoryNoList addonCategory) {
}