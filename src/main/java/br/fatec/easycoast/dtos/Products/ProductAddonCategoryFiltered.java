package br.fatec.easycoast.dtos.Products;

import java.util.List;

import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryNoProduct;

public record ProductAddonCategoryFiltered(
        Integer id,
        String name,
        String description,
        Float price,
        Float discount,
        Boolean availability,
        String category,
        String imageurl,
        List<AddonCategoryNoProduct> addonCategories

) {
}
