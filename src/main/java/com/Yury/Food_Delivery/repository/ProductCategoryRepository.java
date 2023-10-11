package com.Yury.Food_Delivery.repository;

import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.models.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductSubCategory> findSubCategoriesById(Long id);
    Optional<ProductCategory> findByName (String name);
}
