package drug.inventory.management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	 List<OrderItem> findByOrderId(Long orderId);
}
