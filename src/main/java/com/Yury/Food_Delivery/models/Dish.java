package com.Yury.Food_Delivery.models;

import com.Yury.Food_Delivery.enums.DishesCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private DishesCategory dishesCategory;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "calories")
    private Integer calories;
}
