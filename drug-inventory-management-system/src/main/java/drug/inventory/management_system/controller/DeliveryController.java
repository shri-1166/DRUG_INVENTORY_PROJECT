package drug.inventory.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import drug.inventory.management_system.Entity.Delivery;
import drug.inventory.management_system.service.DeliveryService;

@RestController
@RequestMapping("/api")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/admin/delivery/assign")
    public ResponseEntity<Delivery> assignDelivery(@RequestBody Delivery delivery) {
        Delivery assignedDelivery = deliveryService.assignDelivery(delivery);
        return ResponseEntity.ok(assignedDelivery);
    }

    @PutMapping("/delivery/orders/{deliveryId}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(
            @PathVariable Long deliveryId,
            @RequestBody DeliveryStatusRequest statusRequest) throws Exception {
        Delivery updatedDelivery = deliveryService.updateDeliveryStatus(deliveryId, statusRequest.getStatus());
        return ResponseEntity.ok(updatedDelivery);
    }

    @GetMapping("/delivery/orders/{orderId}")
    public ResponseEntity<Delivery> getDeliveryByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(deliveryService.getDeliveryByOrderId(orderId));
    }

    @GetMapping("/delivery/deliveries")
    public ResponseEntity<List<Delivery>> getDeliveriesByDeliveryPerson(@RequestParam Long deliveryPersonId) {
        return ResponseEntity.ok(deliveryService.getDeliveriesByDeliveryPerson(deliveryPersonId));
    }
}

class DeliveryStatusRequest {
    private Delivery.Status status;

    public Delivery.Status getStatus() {
        return status;
    }

    public void setStatus(Delivery.Status status) {
        this.status = status;
    }
}