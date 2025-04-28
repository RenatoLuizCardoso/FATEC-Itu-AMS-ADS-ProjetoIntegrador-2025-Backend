package br.fatec.easycoast.dtos.product;

// classe AddonCategory retirado para não ficar redundante. 
public record ProductFiltered(
        Integer id,
        String name,
        String description,
        Float price,
        Float discount,
        Boolean availability,
        String category,
        String imageurl

) {
}
