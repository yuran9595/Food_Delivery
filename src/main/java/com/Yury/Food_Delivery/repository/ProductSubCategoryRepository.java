package com.Yury.Food_Delivery.repository;

import com.Yury.Food_Delivery.models.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
}
