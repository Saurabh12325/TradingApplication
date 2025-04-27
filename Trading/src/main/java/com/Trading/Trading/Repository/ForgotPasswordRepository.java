package com.Trading.Trading.Repository;

import com.Trading.Trading.Entity.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken,Long> {
    ForgotPasswordToken findByUserId(Long userId);
}
