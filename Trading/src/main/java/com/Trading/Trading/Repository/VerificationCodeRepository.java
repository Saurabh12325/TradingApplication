package com.Trading.Trading.Repository;

import com.Trading.Trading.Entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode,Long> {
 VerificationCode findByUserId(Long userId);

}
