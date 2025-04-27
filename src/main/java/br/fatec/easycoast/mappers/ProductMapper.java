package br.fatec.easycoast.mappers;

import br.fatec.easycoast.dtos.Products.productAddonCategoryFiltered;
import br.fatec.easycoast.dtos.Products.productFiltered;
import br.fatec.easycoast.dtos.Products.productRequest;
import br.fatec.easycoast.dtos.Products.productResponse;
import br.fatec.easycoast.entities.Product;

public class ProductMapper {

  public static Product toEntity(productRequest request) {
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
  public static productResponse toDTO(Product product) {

    return new productResponse(
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

  public static productAddonCategoryFiltered toDTOFiltered(Product product) {
    return new productAddonCategoryFiltered(
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

  public static productFiltered getProductFiltered(Product product) {
    return new productFiltered(
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
