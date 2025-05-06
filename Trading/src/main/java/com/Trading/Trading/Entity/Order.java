package com.Trading.Trading.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private UserEntity user;
}
