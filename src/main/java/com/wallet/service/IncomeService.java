package com.wallet.service;

import com.wallet.dto.CreateIncomeRequest;
import com.wallet.entity.Category;
import com.wallet.entity.Income;
import com.wallet.repository.CategoryRepository;
import com.wallet.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final CategoryRepository categoryRepository;

    public Income createIncome(CreateIncomeRequest request){
        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() -> new NoSuchElementException("Category does not exist!"));

        Income income = new Income(request.getAmount(), category);

        return  incomeRepository.save(income);
    }

    public List<Income> getAllIncomes(){
       return incomeRepository.findAll();
    }

    public Income updateIncome(Long id, CreateIncomeRequest request){
       Income income = incomeRepository.findById(id).orElseThrow(
               () -> new NoSuchElementException("Income record does not exist! " + id));

       Category category = categoryRepository.findByName(request.getCategoryName()).
               orElseThrow(() -> new NoSuchElementException("Category does not exist!"));

       income.setAmount(request.getAmount());
       income.setCategory(category);

       return incomeRepository.save(income);
    }

    public Income patchIncome(Long id, CreateIncomeRequest request){
        Income income = incomeRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Income record does not exist! " + id));

        if(request.getAmount() != null){
            income.setAmount(request.getAmount());
        }

        if(request.getCategoryName() != null){
            Category category = categoryRepository.findByName(request.getCategoryName()).
                    orElseThrow(() -> new NoSuchElementException("Category does not exist!"));

            income.setCategory(category);
        }

        return incomeRepository.save(income);
    }


}
