package br.fatec.easycoast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fatec.easycoast.entities.Category;

public interface CategoryRepository extends JpaRepository <Category, Integer>{
  
}
