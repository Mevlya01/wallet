package com.wallet;

import java.time.Instant;

public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense){
        expense.setCreationTime(Instant.now());
        Expense savedExpense = expenseRepository.save(expense);
        return savedExpense;
    }
}
