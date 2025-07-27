package drug.inventory.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import drug.inventory.management_system.Entity.Order;
import drug.inventory.management_system.Entity.OrderItem;
import drug.inventory.management_system.Entity.User;
import drug.inventory.management_system.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/customer/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        Order order = new Order();
        order.setCustomer(orderRequest.getCustomer());
        List<OrderItem> orderItems = orderRequest.getOrderItems();
        Order savedOrder = orderService.createOrder(order, orderItems);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/customer/orders")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@RequestParam Long customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomer(customerId));
    }

    @GetMapping("/delivery/orders")
    public ResponseEntity<List<Order>> getOrdersByDeliveryPerson(@RequestParam Long deliveryPersonId) {
        return ResponseEntity.ok(orderService.getOrdersByDeliveryPerson(deliveryPersonId));
    }
}

class OrderRequest {
    private User customer;
    private List<OrderItem> orderItems;

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}