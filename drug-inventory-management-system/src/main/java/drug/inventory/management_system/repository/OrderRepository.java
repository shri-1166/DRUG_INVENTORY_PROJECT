package drug.inventory.management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	 List<Order> findByCustomerId(Long customerId);
	    List<Order> findByDeliveryPersonId(Long deliveryPersonId);
	
}
