package com.wallet.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "expenses", indexes = {
@Index(name = "idx_category_id", columnList = "category_id")
})
@Getter
@Setter
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Column(name = "creation_time", nullable = false, updatable = false)
    private Instant creationTime = Instant.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    public Expense( BigDecimal amount, Category category) {
        this.amount = amount;
        this.category = category;
    }

}
