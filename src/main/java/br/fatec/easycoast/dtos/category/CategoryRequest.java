package br.fatec.easycoast.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryRequest(

@NotBlank(message = "Nome da Categoria não pode ser em branco")
@Size(min=3, message = "Tamanho mínimo para nome da categoria é 3")
String name,

@NotNull(message = "Disponibilidade não pode ser em branco")
Boolean availability
) {
  
}
