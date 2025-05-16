package com.Trading.Trading.Entity;

import com.Trading.Trading.Domain.PaymentMethod;
import com.Trading.Trading.Domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;
    private PaymentOrderStatus status;
    private PaymentMethod  paymentMethod;
    @ManyToOne
    private UserEntity user;
}
