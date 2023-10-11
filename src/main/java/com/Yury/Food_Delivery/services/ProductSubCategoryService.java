package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.models.ProductSubCategory;

import java.util.List;

public interface ProductSubCategoryService {

    List<ProductSubCategory> getAllSubCategoriesByCategoryId(Long categoryId);
     ProductCategory addSubCategory(Long categoryId, ProductSubCategory productSubCategory);
}
