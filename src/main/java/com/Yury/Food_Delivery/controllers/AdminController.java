package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.dto.UserDTOResponse;
import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.models.ProductSubCategory;
import com.Yury.Food_Delivery.services.Impl.ProductCategoryServiceImpl;
import com.Yury.Food_Delivery.services.Impl.ProductSubCategoryServiceImpl;
import com.Yury.Food_Delivery.services.Impl.UserServiceImpl;
import com.Yury.Food_Delivery.validation.CategoryValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Slf4j
public class AdminController {
    private final UserServiceImpl userService;
    private final ProductCategoryServiceImpl categoryService;
    private final ProductSubCategoryServiceImpl productSubCategoryService;
    private final CategoryValidation categoryValidation;

    @PostMapping("/setUserToActive/{userId}")
    public ResponseEntity<UserDTOResponse> setUserToActive (@PathVariable Long userId){
       return ResponseEntity.ok(userService.setUserToActive(userId));
    }
    @PostMapping("/setUserToInactive/{userId}")
    public ResponseEntity<UserDTOResponse> setUserToInactive (@PathVariable Long userId){
        return ResponseEntity.ok(userService.setUserToInactive(userId));
    }
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody ProductCategory productCategory, BindingResult bindingResult){
        categoryValidation.validate(productCategory, bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError("name"), HttpStatus.BAD_REQUEST);
        }
        ProductCategory category = categoryService.addCategory(productCategory);
        log.info("Добавлена категория: " + category.getName());
        return ResponseEntity.ok(category);
    }
    @PostMapping("/setInactiveStatus/{categoryId}")
    public ResponseEntity<?> changeStatusToInactive(@PathVariable Long categoryId){
        ProductCategory productCategory = categoryService.setStatusToInactive(categoryId);
        if (productCategory==null){
            return new ResponseEntity<>("Category with such id is not found!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productCategory);
    }
    @PostMapping("/addSubCategory/{categoryId}")
    public ResponseEntity<?> addSubCategory(@RequestBody ProductSubCategory productSubCategory,
                                            @PathVariable Long categoryId){
        ProductCategory productCategory = productSubCategoryService.addSubCategory(categoryId, productSubCategory);
        if (productCategory!=null){
            return ResponseEntity.ok(productCategory);
        }
        return new ResponseEntity<>("Category with such id is not found!", HttpStatus.BAD_REQUEST);
    }


}
