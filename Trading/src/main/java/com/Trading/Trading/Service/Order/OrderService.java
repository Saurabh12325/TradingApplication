package com.Trading.Trading.Service.Order;

import com.Trading.Trading.Domain.OrderType;
import com.Trading.Trading.Entity.Coin;
import com.Trading.Trading.Entity.Order;
import com.Trading.Trading.Entity.OrderItem;
import com.Trading.Trading.Entity.UserEntity;

import java.util.List;

public interface OrderService {

    Order createOrder(UserEntity user ,OrderItem orderItem, OrderType OrderType);

    Order getOrderById(Long orderId);
    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType,String assetSymbol);

    Order processOrder(Coin coin, double quantity,OrderType orderType,UserEntity user);


}
