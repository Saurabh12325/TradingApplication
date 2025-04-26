package com.Trading.Trading.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class TwoFactorOTP {

    @Id
    private String id;
    private String otp;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    private UserEntity user;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String jwt;


}
