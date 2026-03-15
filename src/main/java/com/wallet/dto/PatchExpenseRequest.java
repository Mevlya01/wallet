package com.wallet.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PatchExpenseRequest {
    private String title;
    private BigDecimal amount;
    private String categoryName;
}
