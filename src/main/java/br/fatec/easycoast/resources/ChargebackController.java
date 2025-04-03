package br.fatec.easycoast.resources;

import br.fatec.easycoast.entities.Chargeback;
import br.fatec.easycoast.dtos.ChargebackResponse;
import br.fatec.easycoast.services.ChargebackService;
import br.fatec.easycoast.mappers.ChargebackMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chargebacks")
public class ChargebackController {

    private final ChargebackService chargebackService;
    private final ChargebackMapper chargebackMapper;

    //@Autowired
    public ChargebackController(ChargebackService chargebackService, ChargebackMapper chargebackMapper) {
        this.chargebackService = chargebackService;
        this.chargebackMapper = chargebackMapper;
    }

    @PostMapping
    public ChargebackResponse createChargeback(@RequestBody Chargeback chargeback) {
        Chargeback savedChargeback = chargebackService.createChargeback(chargeback);
        return chargebackMapper.toChargebackResponse(savedChargeback);
    }

    @GetMapping("/{id}")
    public ChargebackResponse getChargeback(@PathVariable Integer id) {
        Optional<Chargeback> chargebackOptional = chargebackService.getChargebackById(id);
        return chargebackOptional.map(chargebackMapper::toChargebackResponse)
                .orElseThrow(() -> new RuntimeException("Chargeback not found"));
    }
}
