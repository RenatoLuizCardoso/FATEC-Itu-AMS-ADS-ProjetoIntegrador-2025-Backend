package br.fatec.easycoast.dtos.addon;

import br.fatec.easycoast.dtos.addonCategory.AddonCategoryResponse;
import br.fatec.easycoast.dtos.item.ItemResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record AddonResponse(
        Integer id,
        String name,
        Float price,
        Boolean availability,
        ItemResponse item,
        @JsonIgnoreProperties("addons") AddonCategoryResponse addonCategory) {
}