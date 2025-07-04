package br.fatec.easycoast.dtos.subcategory;

import br.fatec.easycoast.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubcategoryRequest(
        Integer id,
        @NotBlank(message = "The name of subcategory cannot be blank.") @NotNull(message = "The name cannot be null. ") String name,
        @NotBlank(message = "The availability cannot be blank.") @NotNull(message = "The availability cannot be null") Boolean availability,
        @NotNull(message = "The category cannot by null") Category category

) {
}