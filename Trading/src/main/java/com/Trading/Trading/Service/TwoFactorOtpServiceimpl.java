package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.TwoFactorOTP;
import com.Trading.Trading.Entity.UserEntity;

public class TwoFactorOtpServiceimpl implements TwoFactorOtpService {
    @Override
    public TwoFactorOTP createTwoFactorOtp(UserEntity user, String otp, String jwt) {
        return null;
    }

    @Override
    public TwoFactorOTP findByUserEntity(Long userId) {
        return null;
    }

    @Override
    public TwoFactorOTP findById(TwoFactorOTP twoFactorOTP) {
        return null;
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP) {
        return false;
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP) {

    }
}
