package com.Trading.Trading.Service.Payment;

import com.Trading.Trading.DTO.PaymentResponse;
import com.Trading.Trading.Domain.PaymentMethod;
import com.Trading.Trading.Entity.PaymentOrder;
import com.Trading.Trading.Entity.UserEntity;

public interface PaymentService {
    PaymentOrder createOrder(UserEntity user, Long amount, PaymentMethod paymentMethod);
    PaymentOrder getPaymentOrderById(Long id);
    Boolean ProceedPaymentOrder(PaymentOrder paymentOrder,String PaymentId);
    PaymentResponse createRazorPayment(UserEntity user , Long amount);
    PaymentResponse createStripePayment(UserEntity user , Long amount, Long OrderId);
}
