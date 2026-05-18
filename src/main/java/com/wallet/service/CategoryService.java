package com.wallet.service;

import com.wallet.dto.CreateCategoryRequest;
import com.wallet.entity.Category;
import com.wallet.repository.CategoryRepository;
import com.wallet.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;

    public Category createCategory(CreateCategoryRequest request){
        Category category = new Category(request.getName(),
                request.getType(), false);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(String name, CreateCategoryRequest request){
        Category category = categoryRepository.findByName(name).
                orElseThrow(() -> new IllegalArgumentException(
                        "Category not found : " + name ));

        if(category.getDefaultCategory() == true){
            throw new IllegalArgumentException("Cannot update default categories.");
        }

        category.setName(request.getName());
        category.setType(request.getType());
        return categoryRepository.save(category);
    }

    public void deleteCategory(String name){

        Category category = categoryRepository.findByName(name).orElseThrow(
                () -> new NoSuchElementException( "Category not found : " + name));

        if (category.getDefaultCategory()){
            throw new IllegalArgumentException("Cannot delete default categories.");
        }

        boolean hasExpenseRecord = expenseRepository.existsByCategoryId(category.getId());

        if(hasExpenseRecord){
            throw new IllegalStateException(
                    "Cannot delete a category with expense records.");
        }

        categoryRepository.delete(category);
    }
}
