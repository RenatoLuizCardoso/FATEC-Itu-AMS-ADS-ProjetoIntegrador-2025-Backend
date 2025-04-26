package br.fatec.easycoast.dtos.Products;

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
