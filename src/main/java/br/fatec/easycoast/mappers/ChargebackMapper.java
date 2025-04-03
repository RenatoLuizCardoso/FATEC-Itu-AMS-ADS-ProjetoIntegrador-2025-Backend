package br.fatec.easycoast.mappers;

import br.fatec.easycoast.entities.Chargeback;
import br.fatec.easycoast.dtos.ChargebackResponse;
import org.springframework.stereotype.Component;

@Component
public class ChargebackMapper {

    public ChargebackResponse toChargebackResponse(Chargeback chargeback) {
        return new ChargebackResponse(
                chargeback.getId(),
                chargeback.getTicket().getId(),
                chargeback.getMotive(),
                chargeback.getChargebackDate()
        );
    }
}
