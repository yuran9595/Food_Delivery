package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.models.Dish;
import com.Yury.Food_Delivery.repository.DishesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishesService {

    private final DishesRepository dishesRepository;

    public List<Dish> getAllDishes() {
        
        return dishesRepository.findAll();
    }
    public Dish addDish (Dish dish) {

       return dishesRepository.save(dish);
    }


}
