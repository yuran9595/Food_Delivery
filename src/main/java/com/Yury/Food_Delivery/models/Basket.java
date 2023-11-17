package com.Yury.Food_Delivery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    @ManyToOne
    private Order order;
    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
