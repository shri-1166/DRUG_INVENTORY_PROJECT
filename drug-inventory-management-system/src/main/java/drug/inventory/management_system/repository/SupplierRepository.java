package drug.inventory.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
