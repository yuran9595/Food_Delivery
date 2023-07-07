package com.Yury.Food_Delivery.dto;

import lombok.Data;

@Data
public class JwtRequestDto {
    private String username;
    private String password;
}
