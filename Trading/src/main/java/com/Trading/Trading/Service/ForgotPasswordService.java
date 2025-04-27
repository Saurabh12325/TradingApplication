package com.Trading.Trading.Service;

import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.ForgotPasswordToken;
import com.Trading.Trading.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.awt.*;


public interface ForgotPasswordService {

    ForgotPasswordToken createToken(UserEntity user,String id,String otp, VerificationType verificationType,String sendTo);
    ForgotPasswordToken findById(String id);
    ForgotPasswordToken findByUser(Long userId);
    void deleteToken(ForgotPasswordToken token);
}
