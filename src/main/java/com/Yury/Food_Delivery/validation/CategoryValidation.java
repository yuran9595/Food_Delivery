package com.Yury.Food_Delivery.validation;

import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CategoryValidation implements Validator {
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductCategory.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        ProductCategory productCategory = (ProductCategory) target;
        if (productCategoryRepository.findByName(productCategory.getName()).isPresent()) {
            errors.rejectValue("name", "Error!", "This category already exists!");
        }
    }
}
