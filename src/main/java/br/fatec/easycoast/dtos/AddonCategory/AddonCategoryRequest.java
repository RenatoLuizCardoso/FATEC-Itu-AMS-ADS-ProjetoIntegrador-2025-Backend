package br.fatec.easycoast.dtos.AddonCategory;

import br.fatec.easycoast.entities.Product;
import jakarta.validation.constraints.NotBlank;

public record addonCategoryRequest(

                @NotBlank(message = "Nome da categoria de adicionais não pode ser vazio. ") String name,
                addonType type,
                Product product) {
}