package com.wallet.controller;

import com.wallet.dto.CreateIncomeRequest;
import com.wallet.entity.Income;
import com.wallet.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
