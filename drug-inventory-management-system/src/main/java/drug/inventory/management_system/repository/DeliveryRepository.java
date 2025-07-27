package drug.inventory.management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByOrderId(Long orderId);
    List<Delivery> findByDeliveryPersonId(Long deliveryPersonId);
}