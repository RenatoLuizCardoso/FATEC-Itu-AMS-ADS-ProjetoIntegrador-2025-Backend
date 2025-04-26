package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.entities.Addon;
import br.fatec.easycoast.entities.resources.AddonType;

public record AddonCategoryFiltered(
                Integer id,
                String name,
                AddonType type,
                List<Addon> addons) {

}
