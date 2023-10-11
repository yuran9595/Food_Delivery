package com.Yury.Food_Delivery.controllers;


import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.repository.ProductCategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductCategoryControllerTest {
    @Mock
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void getAllCategoriesTest() throws Exception {
//        Mockito.when(productCategoryRepository.findAll()).thenReturn(List.of(new ProductCategory(1L, "Наушники", null, null, null, true, null)));
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.get("/api/v1/category/getAllCategories")
//                                .with(SecurityMockMvcRequestPostProcessors.user("testUser").roles("ADMIN"))
//                )
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"lastUpdatedDate\":null,\"createdDate\":null,\"productSubCategories\":[],\"name\":\"Наушники\",\"description\":null,\"active\":true,\"id\":2}]"));
//    }
}
