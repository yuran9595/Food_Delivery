package com.Yury.Food_Delivery.validation;

import com.Yury.Food_Delivery.dto.UserDTORequest;
import com.Yury.Food_Delivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserDTOValidation implements Validator {
    private final UserRepository userRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTORequest.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        UserDTORequest userDTO = (UserDTORequest) target;
        if (userRepository.findByLogin(userDTO.getLogin())!=null){
            errors.rejectValue("login", "Error!", "This login's user already exists!");
        }
    }
}
