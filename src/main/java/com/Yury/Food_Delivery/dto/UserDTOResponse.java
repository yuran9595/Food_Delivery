package com.Yury.Food_Delivery.dto;

import com.Yury.Food_Delivery.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private Long id;
    private String login;
    private Boolean active;
    private Set<UserRole> userRole = new HashSet<>();
}
