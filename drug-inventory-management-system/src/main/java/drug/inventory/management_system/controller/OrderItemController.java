package drug.inventory.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import drug.inventory.management_system.Entity.OrderItem;
import drug.inventory.management_system.service.OrderItemService;

@RestController
@RequestMapping("/api/customer")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/order-items")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@RequestParam Long orderId) {
        return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(orderId));
    }
}