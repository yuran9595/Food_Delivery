package com.Yury.Food_Delivery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_sub_categories")
public class ProductSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(name = "active")
    private boolean active;
    @ManyToOne
    private ProductCategory productCategory;
    @OneToMany(mappedBy = "productSubCategory")
    List<Product> products = new ArrayList<>();
}
