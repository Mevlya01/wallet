package com.wallet.controller;

import com.wallet.dto.CreateCategoryRequest;
import com.wallet.entity.Category;
import com.wallet.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryRequest request){
        Category savedCategory = categoryService.createCategory(request);
        return ResponseEntity.ok(savedCategory);
    }
}
