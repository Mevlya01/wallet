package com.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;


@Setter
@Getter
@NoArgsConstructor
public class Income {

    private Long id;
    private BigDecimal amount;
    private Instant creationTime = Instant.now();

    @ManyToOne(optional = false)
    private Category category;

    public Income(BigDecimal amount, Category category){
        this.amount = amount;
        this.category = category;
    }
}
