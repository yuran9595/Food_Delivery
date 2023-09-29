package com.Yury.Food_Delivery.transformers;

import com.Yury.Food_Delivery.dto.UserDTORequest;
import com.Yury.Food_Delivery.dto.UserDTOResponse;
import com.Yury.Food_Delivery.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOResponseTransformer extends Transformer<UserDTOResponse, User>{
    @Override
    public UserDTOResponse transform(User user) {
        UserDTOResponse userDTO = new UserDTOResponse();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setActive(user.getActive());
        userDTO.setUserRole(user.getUserRoles());
        return userDTO;
    }
}
