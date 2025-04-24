package com.Trading.Trading.Entity;

import com.Trading.Trading.Domain.VerificationType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
