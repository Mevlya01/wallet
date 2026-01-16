package com.wallet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private BigDecimal amount;

    @Column(nullable = false, updatable = false)
    private Instant creationTime = Instant.now();

    public Expense( String title, BigDecimal amount) {
        this.title = title;
        this.amount = amount;
    }

}
