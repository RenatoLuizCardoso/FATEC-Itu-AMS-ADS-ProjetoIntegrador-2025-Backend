package br.fatec.easycoast.dtos.Addon;

import br.fatec.easycoast.dtos.ItemResponse;

public record AddonFiltered(
                Integer id,
                String name,
                Float price,
                Boolean availability,
                ItemResponse item

) {
}