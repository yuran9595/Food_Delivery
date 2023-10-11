package com.Yury.Food_Delivery.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;
    @ManyToOne
    private Distributor distributor;
    @ManyToOne
    private ProductSubCategory productSubCategory;
    @ManyToOne
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<Quantity> quantities = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<Basket> baskets = new ArrayList<>();
}
