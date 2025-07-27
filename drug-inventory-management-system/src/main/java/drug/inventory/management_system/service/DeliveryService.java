package drug.inventory.management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drug.inventory.management_system.Entity.Delivery;
import drug.inventory.management_system.repository.DeliveryRepository;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery assignDelivery(Delivery delivery) {
        delivery.setStatus(Delivery.Status.ASSIGNED);
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDeliveryStatus(Long deliveryId, Delivery.Status status) throws Exception {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new Exception("Delivery not found with id: " + deliveryId));
        delivery.setStatus(status);
        return deliveryRepository.save(delivery);
    }

    public Delivery getDeliveryByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }

    public List<Delivery> getDeliveriesByDeliveryPerson(Long deliveryPersonId) {
        return deliveryRepository.findByDeliveryPersonId(deliveryPersonId);
    }
}