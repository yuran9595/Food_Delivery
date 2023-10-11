package com.Yury.Food_Delivery.models;

import lombok.*;

import javax.persistence.*;
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
