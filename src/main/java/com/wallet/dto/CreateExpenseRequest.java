package com.wallet.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateExpenseRequest {
    private String title;
    private BigDecimal amount;
    private Long categoryId;
}
