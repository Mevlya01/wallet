package com.wallet.controller;

import com.wallet.entity.Expense;
import com.wallet.dto.CreateExpenseRequest;
import com.wallet.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

   private ExpenseService expenseService;

@PostMapping
public ResponseEntity<Expense> createExpense(@RequestBody CreateExpenseRequest request){

    Expense savedExpense = expenseService.createExpense(request);
    return ResponseEntity.ok(savedExpense);
}





}
