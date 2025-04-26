package com.Trading.Trading.Entity;

import com.Trading.Trading.Domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String otp;

    @OneToOne
    private UserEntity user;

    private String email;
    private String mobile;
    private VerificationType verificationType;

}

