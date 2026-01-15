package com.wallet.controller;
import com.wallet.Expense;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

@PostMapping
public ResponseEntity<Expense> createExpense(@RequestBody Expense request){

return ResponseEntity.status(201).body(request);
}

@GetMapping("/id")
    public ResponseEntity<?> getExpense(@PathVariable("id") int id){
    return ResponseEntity.ok(id);
}



}
