package br.fatec.easycoast.dtos.Products;

// classe AddonCategory retirado para não ficar redundante. 
public record productFiltered(
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
