package com.wallet.controller;
import com.wallet.Expense;
import com.wallet.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

@PostMapping
public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
    expense.setCreationTime(Instant.now());
    Expense savedExpense = expenseRepository.save(expense);
       return ResponseEntity.ok(savedExpense);
}





}
