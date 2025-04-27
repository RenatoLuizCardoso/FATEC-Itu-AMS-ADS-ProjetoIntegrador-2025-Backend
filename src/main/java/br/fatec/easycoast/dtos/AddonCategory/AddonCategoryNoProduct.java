package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Addon.AddonFiltered;

public record addonCategoryNoProduct(
                Integer id,
                String name,
                addonType type,
                List<AddonFiltered> addons

) {

}