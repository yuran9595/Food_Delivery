package com.Yury.Food_Delivery.services.Impl;

import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.models.ProductSubCategory;
import com.Yury.Food_Delivery.repository.ProductCategoryRepository;
import com.Yury.Food_Delivery.repository.ProductSubCategoryRepository;
import com.Yury.Food_Delivery.services.ProductSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {
    private final ProductSubCategoryRepository productSubCategoryRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductSubCategory> getAllSubCategoriesByCategoryId(Long categoryId) {
        ProductCategory productCategory = productCategoryRepository.findById(categoryId).orElse(null);
        if (productCategory != null) {
            return productCategory.getProductSubCategories();
        }
        return null;
    }

    @Override
    public ProductCategory addSubCategory(Long categoryId, ProductSubCategory productSubCategory) {
        ProductCategory productCategory = productCategoryRepository.findById(categoryId).orElse(null);
        if (productCategory != null) {
            productSubCategory.setActive(true);
            productCategory.getProductSubCategories().add(productSubCategory);
            productCategoryRepository.save(productCategory);
            return productCategory;
        }
        return null;
    }
}
