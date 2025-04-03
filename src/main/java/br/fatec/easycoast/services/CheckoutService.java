package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.CheckoutRequest;
import br.fatec.easycoast.dtos.CheckoutResponse;
import br.fatec.easycoast.entities.Checkout;
import br.fatec.easycoast.repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    public CheckoutResponse createCheckout(CheckoutRequest request) {
        
        Checkout checkout = new Checkout();
        checkout.setDateOpening(request.dateOpening()); 
        checkout.setValueInitial(request.valueInitial()); 
        checkout.setStatus(request.status());
        
        Checkout saved = checkoutRepository.save(checkout);
    
        return new CheckoutResponse(saved.getId(), saved.getDateOpening(), saved.getValueInitial(), saved.getStatus());
    }

    public Optional<CheckoutResponse> getCheckoutById(Integer id) {
        return checkoutRepository.findById(id)
                .map(checkout -> new CheckoutResponse(checkout.getId(), checkout.getDateOpening(), checkout.getValueInitial(), checkout.getStatus()));
    }
}

