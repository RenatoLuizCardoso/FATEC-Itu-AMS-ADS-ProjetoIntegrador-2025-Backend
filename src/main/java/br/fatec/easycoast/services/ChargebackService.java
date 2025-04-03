package br.fatec.easycoast.services;

import br.fatec.easycoast.entities.Chargeback;
import br.fatec.easycoast.repositories.ChargebackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChargebackService {

    private final ChargebackRepository chargebackRepository;

    //@Autowired
    public ChargebackService(ChargebackRepository chargebackRepository) {
        this.chargebackRepository = chargebackRepository;
    }

    public Chargeback createChargeback(Chargeback chargeback) {
        
        return chargebackRepository.save(chargeback);
    }

    public Optional<Chargeback> getChargebackById(Integer id) {
        return chargebackRepository.findById(id);
    }

    public Iterable<Chargeback> getAllChargebacks() {
        return chargebackRepository.findAll();
    }

    public void deleteChargeback(Integer id) {
        chargebackRepository.deleteById(id);
    }
}
