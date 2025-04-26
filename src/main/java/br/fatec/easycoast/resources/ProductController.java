package br.fatec.easycoast.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.easycoast.dtos.Products.ProductRequest;
import br.fatec.easycoast.dtos.Products.ProductResponse;
import br.fatec.easycoast.services.ProductService;
import jakarta.validation.Valid;

@RestController
public class ProductController {

  private ProductService service;

  public ProductController(ProductService productService) {
    this.service = productService;
  }

  @GetMapping("products/{id}")
  public ResponseEntity<ProductResponse> getProductById(@PathVariable int id) {
    return ResponseEntity.ok(service.getProductById(id));
  }

  @GetMapping("products")
  public ResponseEntity<List<ProductResponse>> getProducts() {
    return ResponseEntity.ok(service.getProducts());
  }

  @PostMapping("products")
  public ResponseEntity<ProductResponse> postProduct(@Valid @RequestBody ProductRequest request) {
    ProductResponse product = this.service.postProduct(request);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.id()).toUri();

    return ResponseEntity.created(location).body(product);
  }

  @PutMapping("products/{id}")
  public ResponseEntity<ProductResponse> putProduct(@Valid @PathVariable int id, @RequestBody ProductRequest request) {
    this.service.putProduct(id, request);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("products/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
    this.service.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

}
