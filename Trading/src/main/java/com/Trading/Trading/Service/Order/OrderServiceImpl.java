package com.Trading.Trading.Service.Order;

import com.Trading.Trading.Domain.OrderStatus;
import com.Trading.Trading.Domain.OrderType;
import com.Trading.Trading.Entity.Coin;
import com.Trading.Trading.Entity.Order;
import com.Trading.Trading.Entity.OrderItem;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.OrderRepository;
import com.Trading.Trading.Service.Wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private WalletService walletService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(UserEntity user, OrderItem orderItem, OrderType OrderType) {
     double price = orderItem.getCoin().getCurrentPrice()*orderItem.getQuantity();
     Order order = new Order();
     order.setUser(user);
     order.setOrderItem(orderItem);
     order.setOrderType(OrderType);
     order.setPrice(BigDecimal.valueOf(price));
     order.setTimestamp(LocalDateTime.now());
     order.setStatus(OrderStatus.PENDING);
     orderRepository.save(order);
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
