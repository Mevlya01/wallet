package com.wallet.controller;

import com.wallet.dto.CreateCategoryRequest;
import com.wallet.entity.Category;
import com.wallet.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryRequest request){
        Category savedCategory = categoryService.createCategory(request);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryList);

    }

    @PatchMapping("/{name}")
    public ResponseEntity<Category> patchCategory(@PathVariable String name,
                                                   @RequestBody CreateCategoryRequest request){
        Category category = categoryService.updateCategory(name,request);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteCategory(@PathVariable String name){
        categoryService.deleteCategory(name);
        return ResponseEntity.ok( "Category deleted!");
    }
}
