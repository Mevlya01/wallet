package com.wallet.service;

import com.wallet.dto.CreateExpenseRequest;
import com.wallet.entity.Category;
import com.wallet.entity.Expense;
import com.wallet.repository.CategoryRepository;
import com.wallet.repository.ExpenseRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    public Expense createExpense(CreateExpenseRequest request){

        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Category not found: " + request.getCategoryName()
                ));

        Expense expense = new Expense(
                request.getTitle(),
                request.getAmount(),
                category
        );

        return expenseRepository.save(expense);
    }
}
