package drug.inventory.management_system.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import drug.inventory.management_system.Entity.Order;

@Service
public class PaymentService {
    private RazorpayClient razorpayClient;

    public PaymentService() throws RazorpayException {
        this.razorpayClient = new RazorpayClient("your_key_id", "your_key_secret");
    }

    public String createOrder(double amount) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Amount in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_rcptid_" + System.currentTimeMillis());
        com.razorpay.Order order = razorpayClient.orders.create(orderRequest);
        return order.toString();
    }
}