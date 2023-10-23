package com.Yury.Food_Delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DistributorDTORequest extends UserDTORequest {
    private String nameOfDistributorCompany;

    public DistributorDTORequest(String login, String password) {
        super(login, password);
    }
}
