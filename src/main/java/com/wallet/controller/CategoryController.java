package com.wallet.controller;

import com.wallet.Category;
import com.wallet.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

  public CategoryController(CategoryRepository categoryRepository){
      this.categoryRepository = categoryRepository;
  }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        category.setDefaultCategory(false);
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(savedCategory);
    }
}
