package com.wallet.controller;

import com.wallet.dto.PatchExpenseRequest;
import com.wallet.entity.Expense;
import com.wallet.dto.CreateExpenseRequest;
import com.wallet.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

   private final ExpenseService expenseService;

@PostMapping
public ResponseEntity<Expense> createExpense(@RequestBody CreateExpenseRequest request){

    Expense savedExpense = expenseService.createExpense(request);
    return ResponseEntity.ok(savedExpense);
}


@GetMapping
public ResponseEntity<List<Expense>> getAllExpenses(){
    List<Expense> expenseList = expenseService.getAllExpenses();
    return ResponseEntity.ok(expenseList);
}


@PutMapping("/{id}")
public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                             @RequestBody CreateExpenseRequest request){

    Expense updatedExpense = expenseService.updateExpense(id, request);
    return  ResponseEntity.ok(updatedExpense);
}

@PatchMapping("/{id}")
public ResponseEntity<Expense> patchExpense(@PathVariable Long id,
                                            @RequestBody PatchExpenseRequest request){
    Expense updatedExpense = expenseService.patchExpense(id,request);
    return ResponseEntity.ok(updatedExpense);
}

@GetMapping("/total")
public ResponseEntity<BigDecimal> getTotalExpenses(){
    return ResponseEntity.ok(expenseService.getTotalExpenses());
}

@GetMapping("/total/{name}")
    public ResponseEntity<BigDecimal> getTotalExpensesByCategory(@PathVariable String name){
    return ResponseEntity.ok(expenseService.getTotalExpensesByCategory(name));
}

@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
    expenseService.deleteExpense(id);
    return ResponseEntity.ok("Expense deleted!");
}
}