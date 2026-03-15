package com.wallet.service;

import com.wallet.dto.CreateCategoryRequest;
import com.wallet.entity.Category;
import com.wallet.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CreateCategoryRequest request){
        Category category = new Category(request.getName(), false);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(String name, CreateCategoryRequest request){
        Category category = categoryRepository.findByName(name).
                orElseThrow(() -> new IllegalArgumentException(
                        "Category not found : " + name ));

        category.setName(request.getName());
        return categoryRepository.save(category);
    }
}
