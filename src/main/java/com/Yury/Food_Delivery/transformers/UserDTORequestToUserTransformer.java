package com.Yury.Food_Delivery.transformers;

import com.Yury.Food_Delivery.dto.UserDTORequest;
import com.Yury.Food_Delivery.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTORequestToUserTransformer extends Transformer<User, UserDTORequest>{
    @Override
    public User transform(UserDTORequest userDTO) {
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setLogin(userDTO.getLogin());
        return user;
    }
}
