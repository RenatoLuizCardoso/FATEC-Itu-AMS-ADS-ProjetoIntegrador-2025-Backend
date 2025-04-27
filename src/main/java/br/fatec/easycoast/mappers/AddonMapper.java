package br.fatec.easycoast.mappers;

import java.util.List;

import br.fatec.easycoast.dtos.Addon.addonFiltered;
import br.fatec.easycoast.dtos.Addon.addonNoList;
import br.fatec.easycoast.dtos.Addon.addonRequest;
import br.fatec.easycoast.dtos.Addon.addonResponse;
import br.fatec.easycoast.entities.Addon;

public class AddonMapper {

    public static Addon toEntity(addonRequest request) {
        Addon addon = new Addon();
        addon.setName(request.name());
        addon.setPrice(request.price());
        addon.setAvailability(request.availability());
        addon.setItem(request.item());
        addon.setAddonCategory(request.addonCategory());
        return addon;
    }

    public static addonResponse toDTO(Addon addon) {

        return new addonResponse(
                addon.getId(),
                addon.getName(),
                addon.getPrice(),
                addon.getAvailability(),
                ItemMapper.toDTO(addon.getItem()),
                AddonCategoryMapper.toDTO(addon.getAddonCategory())

        );

    }

    public static List<addonResponse> toListDTO(List<Addon> addons) {
        List<addonResponse> addonResponses = addons.stream()
                .map(addon -> toDTO(addon))
                .toList();
        return addonResponses;
    }

    // Método para enviar somente o AddonCategory, e não enviar Addons também para
    // não ficar redudante e dar loop.
    public static addonNoList toDTONoList(Addon addon) {

        return new addonNoList(
                addon.getId(),
                addon.getName(),
                addon.getPrice(),
                addon.getAvailability(),
                ItemMapper.toDTO(addon.getItem()),
                addon.getAddonCategory() != null ? AddonCategoryMapper.getAddonCategoryNoList(addon.getAddonCategory())
                        : null);

    }

    // Vai converter List<Addon> em AddonFiltered para não enviar produto para não
    // ficar redundante na hora de pesquisar o produto.
    public static List<addonFiltered> getAddonFiltered(List<Addon> addons) {
        List<addonFiltered> addonFiltered = addons.stream()
                .map(a -> a.getAddonFiltered())
                .toList();
        return addonFiltered;

    }

}
