package br.fatec.easycoast.resources;

import br.fatec.easycoast.dtos.CheckoutRequest;
import br.fatec.easycoast.dtos.CheckoutResponse;
import br.fatec.easycoast.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<CheckoutResponse> createCheckout(@RequestBody CheckoutRequest request) {
        CheckoutResponse response = checkoutService.createCheckout(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckoutResponse> getCheckoutById(@PathVariable Integer id) {
        Optional<CheckoutResponse> response = checkoutService.getCheckoutById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
