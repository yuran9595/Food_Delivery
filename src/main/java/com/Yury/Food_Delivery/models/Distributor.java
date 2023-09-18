package com.Yury.Food_Delivery.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "distributors")
public class Distributor extends User{
    @Column(name = "name")
    private String name;
}
