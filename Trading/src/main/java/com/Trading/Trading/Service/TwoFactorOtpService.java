package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.TwoFactorOTP;
import com.Trading.Trading.Entity.UserEntity;

public interface TwoFactorOtpService {

    TwoFactorOTP createTwoFactorOtp(UserEntity user, String otp , String jwt);

    TwoFactorOTP findByUserEntity(Long userId);

    TwoFactorOTP findById(TwoFactorOTP twoFactorOTP);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);

}
