package com.Yury.Food_Delivery.services.Impl;

import com.Yury.Food_Delivery.controllers.ProductCategoryController;
import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.repository.ProductCategoryRepository;
import com.Yury.Food_Delivery.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository categoryRepository;
    @Override
    public List<ProductCategory> getAllCategories() {
        return categoryRepository.findAll().stream()
                .filter(productCategory -> productCategory.isActive())
                .toList();
    }

    @Override
    public ProductCategory addCategory(ProductCategory productCategory) {
        productCategory.setActive(true);
        productCategory.setCreatedDate(LocalDateTime.now());
        productCategory.setLastUpdatedDate(LocalDateTime.now());
        return categoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory setStatusToInactive(Long id) {
        ProductCategory productCategory = categoryRepository.findById(id).orElse(null);
        if (productCategory!=null){
            productCategory.setActive(false);
            return categoryRepository.save(productCategory);
        }
        return null;
    }
}
