package com.Trading.Trading.Entity;

import com.Trading.Trading.Domain.WalletTransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class WalletTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Wallet wallet;  //one wallet have many transaction
    private WalletTransactionType type;
    private LocalDate date;
    private String transferId;
    private String purpose;
    private Long amount;
}
