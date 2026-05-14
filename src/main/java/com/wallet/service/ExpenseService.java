package com.wallet.service;

import com.wallet.dto.CreateExpenseRequest;
import com.wallet.dto.PatchExpenseRequest;
import com.wallet.entity.Category;
import com.wallet.entity.Expense;
import com.wallet.repository.CategoryRepository;
import com.wallet.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class
ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

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

    public List<Expense> getAllExpenses(){

        return expenseRepository.findAll();
    }

    public Expense updateExpense(Long id,CreateExpenseRequest request){

        Expense expense = expenseRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException(
                        "Expense not found : " + id ));

        Category category = categoryRepository.
                findByName(request.getCategoryName()).orElseThrow(
                        () -> new IllegalArgumentException(
                                "Category not found: " + request.getCategoryName()));

        expense.setTitle(request.getTitle());
        expense.setCategory(category);
        expense.setAmount(request.getAmount());

        return expenseRepository.save(expense);

    }

    public Expense patchExpense(Long id, PatchExpenseRequest request){
        Expense expense = expenseRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException(
                        "Expense not found : " + id ));


        if(request.getTitle() != null ){
           expense.setTitle(request.getTitle());
        }
        if(request.getAmount() != null){
            expense.setAmount(request.getAmount());
        }
        if(request.getCategoryName() != null){
            Category category = categoryRepository
                    .findByName(request.getCategoryName())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Category not found: " + request.getCategoryName()));

            expense.setCategory(category);
        }

        return expenseRepository.save(expense);
    }

    public BigDecimal getTotalExpenses(){
        return expenseRepository.getTotalExpenseAmount();
    }

    public BigDecimal getTotalExpensesByCategory(String categoryName){
       Category category = categoryRepository.findByName(categoryName).
               orElseThrow(() -> new IllegalArgumentException(
                "Category not found : " + categoryName ));
        return expenseRepository.getTotalExpenseByCategory(category.getId());
    }

    public void deleteExpense(Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow(
                ()  ->  new IllegalArgumentException("Expense not found : " + id ));

        expenseRepository.delete(expense);
    }

}
