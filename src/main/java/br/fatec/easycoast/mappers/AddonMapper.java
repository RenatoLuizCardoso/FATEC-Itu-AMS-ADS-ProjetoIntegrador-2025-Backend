package br.fatec.easycoast.mappers;

import java.util.List;

import br.fatec.easycoast.dtos.addon.AddonRequest;
import br.fatec.easycoast.dtos.addon.AddonResponse;
import br.fatec.easycoast.entities.Addon;

public class AddonMapper {

    public static Addon toEntity(AddonRequest request) {
        Addon addon = new Addon();
        addon.setName(request.name());
        addon.setPrice(request.price());
        addon.setAvailability(request.availability());
        addon.setItem(request.item());
        addon.setAddonCategory(request.addonCategory());
        return addon;
    }

    public static AddonResponse toDTO(Addon addon) {

        return new AddonResponse(
                addon.getId(),
                addon.getName(),
                addon.getPrice(),
                addon.getAvailability(),
                ItemMapper.toDTO(addon.getItem()),
                AddonCategoryMapper.toDTO(addon.getAddonCategory())

        );

    }

    public static List<AddonResponse> toListDTO(List<Addon> addons) {
        List<AddonResponse> addonResponses = addons.stream()
                .map(addon -> toDTO(addon))
                .toList();
        return addonResponses;
    }

}
