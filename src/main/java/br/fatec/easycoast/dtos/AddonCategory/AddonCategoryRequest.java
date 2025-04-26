package br.fatec.easycoast.dtos.AddonCategory;

import java.util.List;

import br.fatec.easycoast.entities.Addon;
import br.fatec.easycoast.entities.Product;
import jakarta.validation.constraints.NotBlank;
import br.fatec.easycoast.entities.resources.AddonType;

public record AddonCategoryRequest(

                @NotBlank(message = "Nome da categoria de adicionais não pode ser vazio. ") String name,
                AddonType type,
                Product product,
                List<Addon> addons

) {
}