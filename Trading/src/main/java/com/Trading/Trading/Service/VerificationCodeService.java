package com.Trading.Trading.Service;

import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Entity.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode(UserEntity user, VerificationType verificationType);
    VerificationCode getVerificationCodeById(Long id) throws Exception;
    VerificationCode getVerificationCodeByUser(Long userid);
    void deleteVerificationCodeById(VerificationCode verificationCode);
}
