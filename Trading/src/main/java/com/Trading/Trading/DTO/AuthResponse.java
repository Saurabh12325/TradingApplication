package com.Trading.Trading.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class AuthResponse {


  @JsonProperty
    private String jwt;
  @JsonProperty
    private boolean status;
  @JsonProperty
    private String message;
  @JsonProperty
    private boolean isTwoFactorAuthEnabled;
  @JsonProperty
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
