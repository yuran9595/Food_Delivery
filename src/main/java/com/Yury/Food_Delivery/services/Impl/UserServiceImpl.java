package com.Yury.Food_Delivery.services.Impl;

import com.Yury.Food_Delivery.dto.UserDTORequest;
import com.Yury.Food_Delivery.dto.UserDTOResponse;
import com.Yury.Food_Delivery.enums.UserRole;
import com.Yury.Food_Delivery.models.User;
import com.Yury.Food_Delivery.repository.UserRepository;
import com.Yury.Food_Delivery.services.UserService;
import com.Yury.Food_Delivery.transformers.UserDTORequestToUserTransformer;
import com.Yury.Food_Delivery.transformers.UserToUserDTOResponseTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDTORequestToUserTransformer userDTOToUserTransformer;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserToUserDTOResponseTransformer userToUserDTOTransformer;

    @Override
    public UserDTOResponse createUser(UserDTORequest userDTO) {
        User user = userDTOToUserTransformer.transform(userDTO);
        user.setActive(true);
        user.getUserRoles().add(UserRole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        log.info("Добавлен новый юзер - {}", save.getLogin());
        return userToUserDTOTransformer.transform(save);
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public UserDTOResponse setUserToActive(Long userId) {
        Optional<User> userById = userRepository.findById(userId);
        if (userById.isPresent()){
            User user = userById.get();
            user.setActive(true);
            return userToUserDTOTransformer.transform(user);
        }
        return null;
    }

    @Override
    public UserDTOResponse setUserToInactive(Long userId) {
        Optional<User> userById = userRepository.findById(userId);
        if (userById.isPresent()){
            User user = userById.get();
            user.setActive(false);
            return userToUserDTOTransformer.transform(user);
        }
        return null;
    }
    // todo Model: -> Product(поля какие), Category(), subCategory(), категорию только админ может добавлять.


}
