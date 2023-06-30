package com.Yury.Food_Delivery.repository;

import com.Yury.Food_Delivery.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishesRepository extends JpaRepository<Dish, Long> {

}
