package br.fatec.easycoast.dtos.Products;

import java.util.List;

import br.fatec.easycoast.entities.AddonCategory;

// import java.util.List;

public record ProductResponse(
    Integer id,
    String name,
    String description,
    Float price,
    Float discount,
    Boolean availability,
    String category,
    String imageurl,
    List<AddonCategory> addonCategories

) {
}
