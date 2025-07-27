package drug.inventory.management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drug.inventory.management_system.Entity.Order;
import drug.inventory.management_system.Entity.OrderItem;
import drug.inventory.management_system.Entity.Product;
import drug.inventory.management_system.repository.OrderItemRepository;
import drug.inventory.management_system.repository.OrderRepository;
import drug.inventory.management_system.repository.ProductRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(Order order, List<OrderItem> orderItems) throws Exception {
        double totalAmount = 0;
        for (OrderItem item : orderItems) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new Exception("Product not found with id: " + item.getProduct().getId()));
            if (product.getQuantity() < item.getQuantity()) {
                throw new Exception("Insufficient stock for product: " + product.getName());
            }
            totalAmount += product.getPrice() * item.getQuantity();
            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);
        }
        order.setTotalAmount(totalAmount);
        order.setPaymentStatus("PENDING");
        order.setDeliveryStatus("PENDING");
        Order savedOrder = orderRepository.save(order);
        for (OrderItem item : orderItems) {
            item.setOrder(savedOrder);
            orderItemRepository.save(item);
        }
        return savedOrder;
    }

    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getOrdersByDeliveryPerson(Long deliveryPersonId) {
        return orderRepository.findByDeliveryPersonId(deliveryPersonId);
    }
}