package com.Trading.Trading.Entity;

import com.Trading.Trading.Domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
