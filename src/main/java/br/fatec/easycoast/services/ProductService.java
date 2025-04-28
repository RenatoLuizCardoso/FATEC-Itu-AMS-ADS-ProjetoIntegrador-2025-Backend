package br.fatec.easycoast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.product.*;
import br.fatec.easycoast.entities.Product;
import br.fatec.easycoast.mappers.ProductMapper;
import br.fatec.easycoast.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public ProductAddonCategoryFiltered getProductById(int id) {
    return ProductMapper
        .toDTOFiltered(repository.findById(id).orElseThrow(() -> (new EntityNotFoundException("Product not found"))));
  }

  public List<ProductAddonCategoryFiltered> getProducts() {
    return repository.findAll().stream().map(item -> ProductMapper.toDTOFiltered(item)).toList();
  }

  public ProductResponse postProduct(ProductRequest request) {
    return ProductMapper.toDTO(repository.save(ProductMapper.toEntity(request)));
  }

  public void putProduct(int id, ProductRequest request) {
    Product temp = repository.getReferenceById(id);

    temp.setName(request.name());
    temp.setDescription(request.description());
    temp.setPrice(request.price());
    temp.setDiscount(request.discount());
    temp.setAvailability(request.availability());
    temp.setCategory(request.category());
    temp.setAddonsCategories(request.addonCategories());

    repository.save(temp);

    System.out.println(temp.getAddonsCategories());
  }

  public void deleteProduct(int id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new EntityNotFoundException("Product not found");
    }
  }

}
