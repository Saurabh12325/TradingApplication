package com.Trading.Trading.Service.Wallet;

import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Entity.Wallet;

public interface WalletService {
  Wallet getUserWallet(UserEntity user);
  Wallet addBalance(Wallet wallet, Long money);
  Wallet findWalletById(Long id);
  Wallet walletToWalletTransfer(UserEntity sender,Wallet recieverWallet,Long amount);
}
