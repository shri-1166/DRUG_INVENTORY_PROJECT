package drug.inventory.management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayException;

import drug.inventory.management_system.service.PaymentService;

@RestController
@RequestMapping("/api/customer")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public String processPayment(@RequestBody PaymentRequest request) throws RazorpayException {
        return paymentService.createOrder(request.getAmount());
    }
}

class PaymentRequest {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}