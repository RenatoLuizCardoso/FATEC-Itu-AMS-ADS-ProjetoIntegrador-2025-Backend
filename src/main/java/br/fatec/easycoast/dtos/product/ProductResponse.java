package br.fatec.easycoast.dtos.product;

import java.util.List;

import br.fatec.easycoast.entities.AddonCategory;

//AddonCategoryFiltered é uma classe que não tem o Product porque é redundante e vai dar loop com ela. 
public record ProductResponse(
                Integer id,
                String name,
                String description,
                Float price,
                Float discount,
                Boolean availability,
                String category,
                String imageurl,
                List<AddonCategory> addonCategories

) {
}
