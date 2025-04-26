package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.TwoFactorOTP;
import com.Trading.Trading.Entity.UserEntity;

public interface TwoFactorOtpService {

    TwoFactorOTP createTwoFactorOtp(UserEntity user, String otp , String jwt);

    TwoFactorOTP findByUserEntity(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP ,String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);

}
