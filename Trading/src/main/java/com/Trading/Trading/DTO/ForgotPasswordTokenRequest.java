package com.Trading.Trading.DTO;

import com.Trading.Trading.Domain.VerificationType;
import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private VerificationType verificationType;
    private String sendTo;

    public VerificationType getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(VerificationType verificationType) {
        this.verificationType = verificationType;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }
}
