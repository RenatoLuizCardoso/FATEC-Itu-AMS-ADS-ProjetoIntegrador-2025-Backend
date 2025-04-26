package br.fatec.easycoast.mappers;

import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryFiltered;
import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryRequest;
import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryResponse;
import br.fatec.easycoast.dtos.Products.ProductFiltered;
import br.fatec.easycoast.entities.AddonCategory;

public class AddonCategoryMapper {

    public static AddonCategory ToEntity(AddonCategoryRequest request) {
        AddonCategory addonCategory = new AddonCategory();
        addonCategory.setName(request.name());
        addonCategory.setType(request.type());
        // addonCategory.setProduct(request.product());
        addonCategory.setAddons(request.addons());
        return addonCategory;
    }

    public static AddonCategoryResponse toDTO(AddonCategory addonCategory) {
        return new AddonCategoryResponse(addonCategory.getId(),
                addonCategory.getName(), addonCategory.getType(),
                addonCategory.getProduct(), addonCategory.getAddons());

    }

    // public static AddonCategoryFiltered toDTOfiltered(AddonCategory
    // addonCategory) {
    // return new AddonCategoryFiltered(addonCategory.getId(),
    // addonCategory.getName(), addonCategory.getType(),
    // addonCategory.getProduct());
    // }

}
