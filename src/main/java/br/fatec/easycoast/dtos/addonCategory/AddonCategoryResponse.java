package br.fatec.easycoast.dtos.addonCategory;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.fatec.easycoast.dtos.product.ProductResponse;
import br.fatec.easycoast.entities.Addon;

public record AddonCategoryResponse(
                Integer id,
                String name,
                AddonType type,
                @JsonIgnoreProperties("addonCategories") ProductResponse product,
                @JsonIgnoreProperties("addonCategory") List<Addon> addons) {

}
