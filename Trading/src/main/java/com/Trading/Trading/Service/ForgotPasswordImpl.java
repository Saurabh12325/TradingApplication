package com.Trading.Trading.Service;

import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.ForgotPasswordToken;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.ForgotPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgotPasswordImpl implements ForgotPasswordService{
    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;
    @Override
    public ForgotPasswordToken createToken(UserEntity user, String id, String otp, VerificationType verificationType, String sendTo) {
       ForgotPasswordToken token = new ForgotPasswordToken();
       token.setUser(user);
       token.setSendTo(sendTo);
       token.setOtp(otp);
       token.setVerificationType(verificationType);
        return forgotPasswordRepository.save(token);
    }

    @Override
    public ForgotPasswordToken findById(String id) {
        Optional<ForgotPasswordToken> token = forgotPasswordRepository.findById(id);

        return token.orElse(null);
    }

    @Override
    public ForgotPasswordToken findByUser(Long userId) {
        return forgotPasswordRepository.findByUserId(userId);
    }

    @Override
    public void deleteToken(ForgotPasswordToken token) {
     forgotPasswordRepository.delete(token);
    }
}
