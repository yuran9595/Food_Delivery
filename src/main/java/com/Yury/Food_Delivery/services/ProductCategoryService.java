package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.models.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAllCategories();
    ProductCategory addCategory(ProductCategory productCategory);
    ProductCategory setStatusToInactive(Long id);
}
