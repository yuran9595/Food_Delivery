package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.repository.ProductCategoryRepository;
import com.Yury.Food_Delivery.services.Impl.ProductCategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ProductCategoryServiceTest {
    @Mock
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void getAllCategories() {
        Mockito.when(productCategoryRepository.findAll()).thenReturn(List.of(new ProductCategory(1L, "Наушники", "Супер наушники", null, null, true, null)));
        ProductCategoryServiceImpl productCategoryService = new ProductCategoryServiceImpl(productCategoryRepository);
        List<ProductCategory> allCategories = productCategoryService.getAllCategories();
        Assert.assertEquals("Наушники", allCategories.get(0).getName());
    }

    @Test
    public void addCategory() {
    }

    @Test
    @DisplayName("TestSetInactiveForProductCategory")
    public void setStatusToInactive() {
        Optional<ProductCategory> productCategory = Optional.of(new ProductCategory(1L, "Наушники", "Супер наушники", null, null, true, null));
        Mockito.when(productCategoryRepository.findById(ArgumentMatchers.any())).thenReturn(productCategory);
        ProductCategory productCategory1 = productCategory.get();
        productCategory1.setActive(false);
        Mockito.when(productCategoryRepository.save(productCategory.get())).thenReturn(productCategory1);
        ProductCategoryServiceImpl productCategoryService = new ProductCategoryServiceImpl(productCategoryRepository);
        ProductCategory productCategory2 = productCategoryService.setStatusToInactive(ArgumentMatchers.any());
        Assert.assertEquals(true, productCategory2.isActive());
        //todo запустить swagger и addCategoryTest
    }
}