package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.TwoFactorOTP;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.TwoFactorOtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TwoFactorOtpServiceimpl implements TwoFactorOtpService {

    @Autowired
    public TwoFactorOtpRepository TwoFactorOtpRepository;

    @Override
    public TwoFactorOTP createTwoFactorOtp(UserEntity user, String otp, String jwt) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        TwoFactorOTP twoFactorOTP = new TwoFactorOTP();
        twoFactorOTP.setOtp(otp);
        twoFactorOTP.setJwt(jwt);
        twoFactorOTP.setId(id);
        
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
