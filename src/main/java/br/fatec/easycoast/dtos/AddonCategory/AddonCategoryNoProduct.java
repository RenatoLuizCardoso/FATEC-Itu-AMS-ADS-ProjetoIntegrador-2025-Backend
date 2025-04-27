package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.dtos.Addon.addonFiltered;

public record addonCategoryNoProduct(
                Integer id,
                String name,
                addonType type,
                List<addonFiltered> addons

) {

}