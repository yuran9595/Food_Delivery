package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.models.Dish;
import com.Yury.Food_Delivery.services.DishesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dishes")
@RequiredArgsConstructor
public class DishesController {
    private final DishesService dishesService;
    @GetMapping("/")
    public List<Dish> dishes(){

        return dishesService.getAllDishes();
    }
    @PostMapping("/add")
    public Dish dishes(@RequestBody Dish dish)  {
        return dishesService.addDish(dish);
    }

}
