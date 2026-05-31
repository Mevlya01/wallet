package com.wallet.controller;

import com.wallet.dto.CreateIncomeRequest;
import com.wallet.entity.Income;
import com.wallet.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody CreateIncomeRequest request){
       Income income = incomeService.createIncome(request);
       return ResponseEntity.ok(income);
    }

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes(){
        List<Income> allIncomes = incomeService.getAllIncomes();
        return ResponseEntity.ok(allIncomes);
    }

    @PutMapping("{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id,
                                               @RequestBody CreateIncomeRequest request){

        Income income = incomeService.updateIncome(id,request);
        return ResponseEntity.ok(income);
    }

}
