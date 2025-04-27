package com.Trading.Trading.DTO;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String otp;
    private String password;

    public String getOtp() {
        return otp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
