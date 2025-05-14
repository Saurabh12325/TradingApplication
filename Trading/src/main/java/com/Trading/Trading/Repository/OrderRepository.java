package com.Trading.Trading.Repository;

import com.Trading.Trading.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderId(Long userId);
}
