package br.fatec.easycoast.mappers;

import java.util.List;

import br.fatec.easycoast.dtos.AddonCategory.addonCategoryFiltered;
import br.fatec.easycoast.dtos.AddonCategory.addonCategoryNoList;
import br.fatec.easycoast.dtos.AddonCategory.addonCategoryNoProduct;
import br.fatec.easycoast.dtos.AddonCategory.addonCategoryRequest;
import br.fatec.easycoast.dtos.AddonCategory.addonCategoryResponse;
import br.fatec.easycoast.entities.AddonCategory;

public class AddonCategoryMapper {

    public static AddonCategory ToEntity(addonCategoryRequest request) {
        AddonCategory addonCategory = new AddonCategory();
        addonCategory.setName(request.name());
        addonCategory.setType(request.type());
        addonCategory.setProduct(request.product());
        return addonCategory;
    }

    public static addonCategoryResponse toDTO(AddonCategory addonCategory) {

        return new addonCategoryResponse(
                addonCategory.getId(),
                addonCategory.getName(),
                addonCategory.getType(),
                addonCategory.getProduct() != null ? ProductMapper.getProductFiltered(addonCategory.getProduct())
                        : null,
                addonCategory.getAddons() != null ? AddonMapper.getAddonFiltered(addonCategory.getAddons()) : null

        );

    }

    public static addonCategoryFiltered toGetDTO(AddonCategory addonCategory) {
        return new addonCategoryFiltered(
                addonCategory.getId(),
                addonCategory.getName(),
                addonCategory.getType(),
                addonCategory.getProduct() != null ? addonCategory.getProductFiltered() : null,
                addonCategory.getAddons() != null ? AddonMapper.getAddonFiltered(addonCategory.getAddons()) : null

        );

    }

    public static addonCategoryNoProduct getAddonCategoryNoProduct(AddonCategory addonCategory) {
        return new addonCategoryNoProduct(
                addonCategory.getId(), addonCategory.getName(), addonCategory.getType(),
                AddonMapper.getAddonFiltered(addonCategory.getAddons()));

    }

    // Retornar lista sem produto para POST
    public static List<addonCategoryNoProduct> getAddonCategoriesNoProducts(List<AddonCategory> addonCategories) {
        List<addonCategoryNoProduct> addonCategoriesNoProducts = addonCategories.stream()
                .map(addonCategory -> new addonCategoryNoProduct(addonCategory.getId(), addonCategory.getName(),
                        addonCategory.getType(), AddonMapper.getAddonFiltered(addonCategory.getAddons())))
                .toList();
        return addonCategoriesNoProducts;

    }

    public static addonCategoryNoList getAddonCategoryNoList(AddonCategory addonCategory) {
        return new addonCategoryNoList(
                addonCategory.getId(),
                addonCategory.getName(),
                addonCategory.getType(),
                addonCategory.getProduct() != null ? addonCategory.getProductFiltered() : null);

    }

}
