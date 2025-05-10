package br.fatec.easycoast.dtos.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.fatec.easycoast.dtos.square.SquareResponse;

//Notation to avoid loop. 
public record ItemResponse(
                Integer id,
                String name,
                @JsonIgnoreProperties("items") SquareResponse square) {

}
