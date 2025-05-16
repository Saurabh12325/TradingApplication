package com.Trading.Trading.Service.Payment;

import com.Trading.Trading.DTO.PaymentResponse;
import com.Trading.Trading.Domain.PaymentMethod;
import com.Trading.Trading.Domain.PaymentOrderStatus;
import com.Trading.Trading.Entity.PaymentOrder;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.PaymentRepository;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
@Autowired
  private PaymentRepository paymentRepository;
@Value("${stripe.api.key}")
  private String stripeSecretKey;
    @Value("${razorpay.api.key}")
    private String apiKey;
    @Value("${razorpay.api.secret}")
    private String apiSecretKey;

    @Override
    public PaymentOrder createOrder(UserEntity user, Long amount, PaymentMethod paymentMethod) {
        PaymentOrder order = new PaymentOrder();
        order.setAmount(amount);
        order.setPaymentMethod(paymentMethod);
        order.setUser(user);

        return paymentRepository.save(order);
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment order not found"));
    }

    @Override
    public Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException {
        if(paymentOrder.getStatus().equals(PaymentOrderStatus.PENDING))
            if(paymentOrder.getPaymentMethod().equals(PaymentMethod.RAZORPAY)) {
                RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecretKey);
                Payment payment = razorpay.payments.fetch(paymentId);
                Integer amount = payment.get("amount");
                String status = payment.get("status");
               if(status.equals("CAPTURED")) {
                   paymentOrder.setStatus(PaymentOrderStatus.SUCCESS);
                   return true;
               }
               paymentOrder.setStatus(PaymentOrderStatus.FAILED);
               paymentRepository.save(paymentOrder);
               return false;


            }
        return null;
    }
a
    @Override
    public PaymentResponse createRazorPayment(UserEntity user, Long amount) {
        return null;
    }

    @Override
    public PaymentResponse createStripePayment(UserEntity user, Long amount, Long OrderId) {
        return null;
    }
}
