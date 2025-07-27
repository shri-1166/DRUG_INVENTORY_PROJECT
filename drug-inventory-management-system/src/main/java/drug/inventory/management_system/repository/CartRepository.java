package drug.inventory.management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCustomerId(Long customerId);
}
