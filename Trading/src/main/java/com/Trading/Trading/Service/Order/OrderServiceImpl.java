package com.Trading.Trading.Service.Order;

import com.Trading.Trading.Domain.OrderType;
import com.Trading.Trading.Entity.Coin;
import com.Trading.Trading.Entity.Order;
import com.Trading.Trading.Entity.OrderItem;
import com.Trading.Trading.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public Order createOrder(UserEntity user, OrderItem orderItem, OrderType OrderType) {
        return null;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol) {
        return List.of();
    }

    @Override
    public Order processOrder(Coin coin, double quantity, OrderType orderType, UserEntity user) {
        return null;
    }
}
