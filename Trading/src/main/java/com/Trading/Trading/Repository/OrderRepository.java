package com.Trading.Trading.Repository;

import com.Trading.Trading.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
   List <Order> findByUserId(Long userId);
}
