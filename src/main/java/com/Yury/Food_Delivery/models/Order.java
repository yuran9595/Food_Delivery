package com.Yury.Food_Delivery.models;

import com.Yury.Food_Delivery.enums.FormsOfPayments;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "order")
    List<Basket> baskets = new ArrayList<>();
    @Column(name = "order_amount")
    private Double orderAmount;
    @CreationTimestamp
    @Column(name = "day_of_payment")
    private LocalDateTime dayOfPayment;
    @CreationTimestamp
    @Column(name = "date_of_delivery")
    private LocalDateTime dateOfDelivery;
    @Enumerated(EnumType.STRING)
    @Column(name = "forms_of_payments")
    private FormsOfPayments formsOfPayments;


}
