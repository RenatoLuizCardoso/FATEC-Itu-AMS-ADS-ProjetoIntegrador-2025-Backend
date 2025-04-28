package br.fatec.easycoast.mappers;

import br.fatec.easycoast.dtos.product.*;
import br.fatec.easycoast.entities.Product;

public class ProductMapper {

  public static Product toEntity(ProductRequest request) {
    Product product = new Product();

    product.setName(request.name());
    product.setDescription(request.description());
    product.setPrice(request.price());
    product.setDiscount(request.discount());
    product.setAvailability(request.availability());
    product.setCategory(request.category());
    product.setImageurl(request.imageurl());
    product.setAddonsCategories(request.addonCategories());

    return product;
  }

  // Método e classe utilizado para POST
  public static ProductResponse toDTO(Product product) {

    return new ProductResponse(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getDiscount(),
        product.getAvailability(),
        product.getCategory(),
        product.getImageurl(),
        product.getAddonsCategories() != null ? product.getAddonsCategories() : null

    );

  }

  public static ProductAddonCategoryFiltered toDTOFiltered(Product product) {
    return new ProductAddonCategoryFiltered(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getDiscount(),
        product.getAvailability(),
        product.getCategory(),
        product.getImageurl(),
        AddonCategoryMapper.getAddonCategoriesNoProducts(product.getAddonsCategories())

    );

  }

  public static ProductFiltered getProductFiltered(Product product) {
    return new ProductFiltered(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getDiscount(),
        product.getAvailability(),
        product.getCategory(),
        product.getImageurl());

  }
}
