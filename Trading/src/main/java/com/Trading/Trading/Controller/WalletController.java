package com.Trading.Trading.Controller;
import com.Trading.Trading.Entity.Order;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Entity.Wallet;
import com.Trading.Trading.Entity.WalletTransactionEntity;
import com.Trading.Trading.Service.UserService;
import com.Trading.Trading.Service.Wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

@Autowired
    private WalletService walletService;
@Autowired
private UserService userService;
@GetMapping
public ResponseEntity<Wallet> getUserWallet(@RequestHeader("Authorization") String jwt) throws Exception {
    UserEntity user = userService.findUserProfileByJwt(jwt);
    Wallet wallet = walletService.getUserWallet(user);
    return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);

}
@PutMapping("/api/wallet/{walletId}/transfer")
public ResponseEntity<Wallet> walletToWalletTransfer(@RequestHeader("Authorization") String jwt,
                                                     @PathVariable Long walletId,
                                                     @RequestBody WalletTransactionEntity walletTransaction) throws Exception {
    UserEntity sender = userService.findUserProfileByJwt(jwt);
    Wallet receiverWallet = walletService.findWalletById(walletId);
    Wallet wallet = walletService.walletToWalletTransfer(sender,receiverWallet,walletTransaction.getAmount());
    return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
}

@PutMapping("/api/wallet/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(@RequestHeader("Authorization") String jwt, @PathVariable Long orderId) throws Exception {
    UserEntity user = userService.findUserProfileByJwt(jwt);
    Order order = orderService.getOrderById(orderId);
    Wallet wallet = walletService.payOrderPayment(order,user);
    return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
}


}
