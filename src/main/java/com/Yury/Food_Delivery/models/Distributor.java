package com.Yury.Food_Delivery.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "distributors")
public class Distributor extends User{
    @Column(name = "name")
    private String name;
}
