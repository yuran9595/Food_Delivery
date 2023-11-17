package com.Yury.Food_Delivery.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "distributors")
public class Distributor extends User{
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "distributor")
    private List<Product> products = new ArrayList<>();
}
