package br.fatec.easycoast.dtos.subcategory;

import br.fatec.easycoast.entities.Category;

public record SubcategoryResponse(
                Integer id,

                String name,

                Boolean availability,

                Category category) {

}
