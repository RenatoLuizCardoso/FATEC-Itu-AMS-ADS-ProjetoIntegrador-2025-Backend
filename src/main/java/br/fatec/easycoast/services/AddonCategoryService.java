package br.fatec.easycoast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryRequest;
import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryResponse;
import br.fatec.easycoast.entities.AddonCategory;
import br.fatec.easycoast.mappers.AddonCategoryMapper;
import br.fatec.easycoast.repositories.AddonCategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AddonCategoryService {

    @Autowired
    private AddonCategoryRepository addonCategoryRepository;

    public List<AddonCategoryResponse> getAddonCategories() {
        List<AddonCategory> addonCategories = addonCategoryRepository.findAll();
        return addonCategories.stream()
                .map(addoncategory -> AddonCategoryMapper.toDTO(addoncategory))
                .toList();
    }

    public AddonCategoryResponse getAddonCategory(Integer id) {
        AddonCategory addonCategory = addonCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria de adicional não encontrado. "));
        return AddonCategoryMapper.toDTO(addonCategory);

    }

    public AddonCategoryResponse saveAddonCategory(AddonCategoryRequest request) {
        AddonCategory addonCategory = addonCategoryRepository.save(AddonCategoryMapper.ToEntity(request));
        System.out.println(addonCategory);
        return AddonCategoryMapper.toDTO(addonCategory);

    }

    public void updateAddonCategory(Integer id, AddonCategoryRequest request) {
        AddonCategory aux = addonCategoryRepository.getReferenceById(id);
        aux.setName(request.name());
        aux.setType(request.type());
        aux.setProduct(request.product());
        aux.setAddons(request.addons());
        addonCategoryRepository.save(aux);

    }

}
