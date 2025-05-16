package com.Trading.Trading.Service.Payment;

import com.Trading.Trading.DTO.PaymentResponse;
import com.Trading.Trading.Domain.PaymentMethod;
import com.Trading.Trading.Entity.PaymentOrder;
import com.Trading.Trading.Entity.UserEntity;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentOrder createOrder(UserEntity user, Long amount, PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        return null;
    }

    @Override
    public Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String PaymentId) {
        return null;
    }

    @Override
    public PaymentResponse createRazorPayment(UserEntity user, Long amount) {
        return null;
    }

    @Override
    public PaymentResponse createStripePayment(UserEntity user, Long amount, Long OrderId) {
        return null;
    }
}
