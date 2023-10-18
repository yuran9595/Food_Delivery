package com.Yury.Food_Delivery.controllers;


import com.Yury.Food_Delivery.models.ProductCategory;
import com.Yury.Food_Delivery.repository.ProductCategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ProductCategoryControllerTest {
    @MockBean
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("Тест для получения категорий")
    public void getAllCategoriesTest() throws Exception {
        JSONObject jsonObject = new JSONObject("{\"id\":3,\"name\":\"Компьютеры\",\"description\":null,\"createdDate\":null,\"lastUpdatedDate\":null,\"active\":true,\"productSubCategories\":null}");

        List<ProductCategory> productCategoryList = List.of(new ProductCategory(2L, "Наушники", null, null, null, true, null),
                new ProductCategory(3L, "Компьютеры", null, null, null, true, null));
        Mockito.when(productCategoryRepository.findAll()).thenReturn(productCategoryList);
        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/category/getAllCategories")
                                .with(SecurityMockMvcRequestPostProcessors.user("testUser").roles("ADMIN"))
                )
                .andExpect(status().isOk())
                //      .andExpect(content().json("[{\"lastUpdatedDate\":null,\"createdDate\":null,\"productSubCategories\":[],\"name\":\"Наушники\",\"description\":null,\"active\":true,\"id\":2L}]"));
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(2L))
                .andExpect(jsonPath("$[0].name").value("Наушники"))
                .andExpect(jsonPath("$[0].description").isEmpty())
                .andExpect(jsonPath("$[0].createdDate").isEmpty())
                .andExpect(jsonPath("$[0].lastUpdatedDate").isEmpty())
                .andExpect(jsonPath("$[0].active").value(true))
                .andExpect(jsonPath("$[0].productSubCategories").isEmpty());
 //                       .andExpect(content().json("[{\"id\":2,\"name\":\"Наушники\",\"description\":null,\"createdDate\":null,\"lastUpdatedDate\":null,\"active\":true,\"productSubCategories\":null},{\"id\":3,\"name\":\"Компьютеры\",\"description\":null,\"createdDate\":null,\"lastUpdatedDate\":null,\"active\":true,\"productSubCategories\":null}]"));
        System.out.println();
    }
}
