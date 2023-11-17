package com.Yury.Food_Delivery.models;

import com.Yury.Food_Delivery.enums.ReasonForAChangeOfProductQuantity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quantities")
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double quantity;
    private Long previousId;
    private Long nextId;
    @Enumerated(EnumType.STRING)
    @Column(name = "reason_for_a_change")
    private ReasonForAChangeOfProductQuantity reasonForAChangeOfProductQuantity;
    @ManyToOne
    private Product product;

}
