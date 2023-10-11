package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.services.Impl.ProductCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryServiceImpl categoryService;

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<ProductCategory>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
