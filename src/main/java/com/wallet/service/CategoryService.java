package com.wallet.service;

import com.wallet.controller.CategoryController;
import com.wallet.entity.Category;
import com.wallet.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        category.setDefaultCategory(false);
        return categoryRepository.save(category);
    }

}
