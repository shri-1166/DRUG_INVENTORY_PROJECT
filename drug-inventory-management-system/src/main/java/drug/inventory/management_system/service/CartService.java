package drug.inventory.management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drug.inventory.management_system.Entity.Cart;
import drug.inventory.management_system.Entity.Product;
import drug.inventory.management_system.Entity.User;
import drug.inventory.management_system.repository.CartRepository;
import drug.inventory.management_system.repository.ProductRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public Cart addToCart(Long customerId, Long productId, int quantity) throws Exception {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception("Product not found with id: " + productId));
        if (product.getQuantity() < quantity) {
            throw new Exception("Insufficient stock for product: " + product.getName());
        }
        Cart cart = new Cart();
        cart.setCustomer(new User());
        cart.getCustomer().setId(customerId);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public List<Cart> getCartByCustomer(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}