package com.Trading.Trading.Service.Wallet;

import com.Trading.Trading.Entity.Order;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Entity.Wallet;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface WalletService {
  Wallet getUserWallet(UserEntity user);
  Wallet addBalance(Wallet wallet, Long money);
  Wallet findWalletById(Long id) throws Exception;
  Wallet walletToWalletTransfer(UserEntity sender,Wallet recieverWallet,Long amount) throws Exception;
  Wallet payOrderPayment(Order order, UserEntity user);
}
