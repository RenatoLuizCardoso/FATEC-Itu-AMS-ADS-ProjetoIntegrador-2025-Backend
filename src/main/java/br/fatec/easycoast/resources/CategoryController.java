package br.fatec.easycoast.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.easycoast.dtos.CategoryRequest;
import br.fatec.easycoast.dtos.CategoryResponse;
import br.fatec.easycoast.services.CategoryService;

@RestController
public class CategoryController {

  @Autowired
  private CategoryService service;

  @GetMapping("categories")
  public ResponseEntity <List<CategoryResponse>> getCategories(){
    return ResponseEntity.ok(service.getCategories());
  }

   @GetMapping("categories/{id}")
    public ResponseEntity <CategoryResponse> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCategoryById(id));   
    }

    @PostMapping("categories")
    public ResponseEntity <CategoryResponse> save (@RequestBody CategoryRequest category){
        CategoryResponse newCategory = service.save(category);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newCategory.id())
                            .toUri();

        return ResponseEntity.created(location).body(newCategory);
    }

  
}
