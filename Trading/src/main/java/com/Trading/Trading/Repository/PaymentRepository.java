package com.Trading.Trading.Repository;

import com.Trading.Trading.Entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentOrder,Long> {
}
