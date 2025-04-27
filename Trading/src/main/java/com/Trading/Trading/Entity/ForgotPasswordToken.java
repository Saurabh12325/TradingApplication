package com.Trading.Trading.Entity;

import com.Trading.Trading.Domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Entity
@Data
public class ForgotPasswordToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @OneToOne
    private UserEntity user;
    private String otp;
    private VerificationType verificationType;
    private String sendTo;


}
