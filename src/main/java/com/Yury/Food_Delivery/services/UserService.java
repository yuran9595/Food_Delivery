package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.dto.UserDTORequest;
import com.Yury.Food_Delivery.dto.UserDTOResponse;

import java.util.List;

public interface UserService {
    UserDTOResponse createUser(UserDTORequest userDTO);

    List<UserDTOResponse> userList();

    UserDTOResponse setUserToActive(Long userId);

    UserDTOResponse setUserToInactive(Long userId);

    UserDTOResponse getUserById(Long userId);
}
