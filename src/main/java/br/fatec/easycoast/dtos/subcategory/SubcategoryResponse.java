package br.fatec.easycoast.dtos.subcategory;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.fatec.easycoast.entities.Category;
import br.fatec.easycoast.entities.Product;

public record SubcategoryResponse(
        Integer id,

        String name,

        Boolean availability,
        @JsonIgnoreProperties( {
                "subcategory", "subcategories" }) Category category,
        @JsonIgnoreProperties("subcategory") List<Product> products

    ){

}
