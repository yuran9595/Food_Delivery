package com.Yury.Food_Delivery.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    ROLE_USER, ROLE_ADMIN, ROLE_DISTRIBUTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
