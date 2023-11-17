package com.Yury.Food_Delivery.models;

import com.Yury.Food_Delivery.enums.TypeConnection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_connections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConnections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type_connection")
    @Enumerated(EnumType.STRING)
    private TypeConnection typeConnection;
    @Column(name = "detail_connection")
    private String detailConnection;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;
}
