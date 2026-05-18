package com.wallet.service;

import com.wallet.dto.CreateIncomeRequest;
import com.wallet.entity.Category;
import com.wallet.entity.Income;
import com.wallet.repository.CategoryRepository;
import com.wallet.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}
