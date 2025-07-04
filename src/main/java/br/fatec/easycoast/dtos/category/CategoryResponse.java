package br.fatec.easycoast.dtos.category;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.fatec.easycoast.entities.Subcategory;

public record CategoryResponse(

                Integer id,
                String name,
                Boolean availability,
                @JsonIgnoreProperties("category") List<Subcategory> subcategories) {

}
