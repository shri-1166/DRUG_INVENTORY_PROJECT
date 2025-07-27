package drug.inventory.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
