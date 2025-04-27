package com.Trading.Trading.Service;

import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.ForgotPasswordToken;
import com.Trading.Trading.Entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordImpl implements ForgotPasswordService{
    @Override
    public ForgotPasswordToken createToken(UserEntity user, String id, String otp, VerificationType verificationType, String sendTo) {
        return null;
    }

    @Override
    public ForgotPasswordToken findById(String id) {
        return null;
    }

    @Override
    public ForgotPasswordToken findByUser(Long userId) {
        return null;
    }

    @Override
    public void deleteToken(ForgotPasswordToken token) {

    }
}
