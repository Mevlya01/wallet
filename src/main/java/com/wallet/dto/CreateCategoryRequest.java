package com.wallet.dto;

import com.wallet.enums.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCategoryRequest {
    private String name;
    private CategoryType type;
}
