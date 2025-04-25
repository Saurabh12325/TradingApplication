package com.Trading.Trading.DTO;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class AuthResponse {
    private String jwt;
    private boolean status;
    private String message;
    private boolean isTwoFactorAuthEnabled;
    private String session;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTwoFactorAuthEnabled(boolean twoFactorAuthEnabled) {
        isTwoFactorAuthEnabled = twoFactorAuthEnabled;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
