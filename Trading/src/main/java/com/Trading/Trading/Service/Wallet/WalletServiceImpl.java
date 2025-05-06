package com.Trading.Trading.Service.Wallet;

import com.Trading.Trading.Entity.Order;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Entity.Wallet;
import com.Trading.Trading.Repository.WalletRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet getUserWallet(UserEntity user) {
        Wallet wallet = walletRepository.findByUserId(user.getId());
        if(wallet==null){
            wallet = new Wallet();
            wallet.setUser(user);

        }
        return wallet;
    }

    @Override
    public Wallet addBalance(Wallet wallet, Long money) {
        BigDecimal balance = wallet.getBalance();
        BigDecimal newBalance = balance.add(BigDecimal.valueOf(money));
        wallet.setBalance(newBalance);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findWalletById(Long id) throws Exception {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            wallet.get();
        }
        throw  new Exception("Wallet not found");
    }

    @Override
    public Wallet walletToWalletTransfer(UserEntity sender, Wallet recieverWallet, Long amount) throws Exception {
        Wallet senderWallet = getUserWallet(sender);
        if(senderWallet.getBalance().compareTo(BigDecimal.valueOf(amount))<0){
            throw new Exception("Insufficient Balance......");
        }
        BigDecimal senderbalance = senderWallet.getBalance().subtract(BigDecimal.valueOf(amount));
        senderWallet.setBalance(senderbalance);
        walletRepository.save(senderWallet);

        // receiver wallet update
        BigDecimal receiverbalance = recieverWallet.getBalance().add(BigDecimal.valueOf(amount));
        recieverWallet.setBalance(receiverbalance);
        walletRepository.save(recieverWallet);
        return senderWallet;
    }

    @Override
    public Wallet payOrderPayment(Order order, UserEntity user) {
        Wallet wallet = getUserWallet(user);
        if(order.getO)
        return null;
    }
}
