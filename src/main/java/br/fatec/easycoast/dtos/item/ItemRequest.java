package br.fatec.easycoast.dtos.item;

import br.fatec.easycoast.entities.Square;

public record ItemRequest(
    String name,
    Square square
) {

}
