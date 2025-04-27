package br.fatec.easycoast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.AddonCategory.addonCategoryFiltered;
import br.fatec.easycoast.dtos.AddonCategory.addonCategoryRequest;
import br.fatec.easycoast.dtos.AddonCategory.addonCategoryResponse;
import br.fatec.easycoast.entities.AddonCategory;
import br.fatec.easycoast.mappers.AddonCategoryMapper;
import br.fatec.easycoast.repositories.AddonCategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AddonCategoryService {

    @Autowired
    private AddonCategoryRepository addonCategoryRepository;

    public List<addonCategoryFiltered> getAddonCategories() {
        List<AddonCategory> addonCategories = addonCategoryRepository.findAll();
        return addonCategories.stream()
                .map(addoncategory -> AddonCategoryMapper.toGetDTO(addoncategory))
                .toList();
    }

    public addonCategoryFiltered getAddonCategory(Integer id) {
        AddonCategory addonCategory = addonCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria de adicional não encontrado. "));
        return AddonCategoryMapper.toGetDTO(addonCategory);

    }

    public addonCategoryResponse saveAddonCategory(addonCategoryRequest request) {
        AddonCategory addonCategory = addonCategoryRepository.save(AddonCategoryMapper.ToEntity(request));
        return AddonCategoryMapper.toDTO(addonCategory);

    }

    public void updateAddonCategory(Integer id, addonCategoryRequest request) {
        AddonCategory aux = addonCategoryRepository.getReferenceById(id);
        aux.setName(request.name());
        aux.setType(request.type());
        aux.setProduct(request.product());
        addonCategoryRepository.save(aux);

    }

}
