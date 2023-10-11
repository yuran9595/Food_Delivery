package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.models.ProductSubCategory;
import com.Yury.Food_Delivery.services.Impl.ProductSubCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sub_category")
@RequiredArgsConstructor
public class ProductSubCategoryController {
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    @GetMapping("/getSubCategories/{categoryId}")
    public ResponseEntity<List<ProductSubCategory>> getAllSubCategories (@PathVariable Long categoryId){
        return ResponseEntity.ok(productSubCategoryService.getAllSubCategoriesByCategoryId(categoryId));
    }
}
