package com.Trading.Trading.DTO;

import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private String otp;
    private String sendTo;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }
}
