package com.wallet.controller;
import com.wallet.entity.Category;
import com.wallet.repository.CategoryRepository;
import com.wallet.entity.Expense;
import com.wallet.repository.ExpenseRepository;
import com.wallet.dto.CreateExpenseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseController(ExpenseRepository expenseRepository,
                             CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

@PostMapping
public ResponseEntity<Expense> createExpense(@RequestBody CreateExpenseRequest request){

    Category category = categoryRepository.findByName(request.getCategoryName())
                    .orElseThrow(() -> new RuntimeException("Category not found"));

    Expense expense = new Expense(
            request.getTitle(),
            request.getAmount(),
            category
    );

    Expense savedExpense = expenseRepository.save(expense);

    return ResponseEntity.ok(savedExpense);
}





}
