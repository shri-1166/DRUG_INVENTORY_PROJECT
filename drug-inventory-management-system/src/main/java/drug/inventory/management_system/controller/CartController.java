package drug.inventory.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import drug.inventory.management_system.Entity.Cart;
import drug.inventory.management_system.service.CartService;

@RestController
@RequestMapping("/api/customer")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<Cart> addToCart(
            @RequestParam Long customerId,
            @RequestParam Long productId,
            @RequestParam int quantity) throws Exception {
        Cart cart = cartService.addToCart(customerId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getCartByCustomer(@RequestParam Long customerId) {
        return ResponseEntity.ok(cartService.getCartByCustomer(customerId));
    }

    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
        return ResponseEntity.ok().build();
    }
}