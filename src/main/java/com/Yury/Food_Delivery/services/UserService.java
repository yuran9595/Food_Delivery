package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.enums.UserRole;
import com.Yury.Food_Delivery.models.User;
import com.Yury.Food_Delivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String login = user.getLogin();
        if (userRepository.findByLogin(login) != null) {
            return false;
        }
        user.setActive(true);
        user.getUserRoles().add(UserRole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        log.info("Добавлен новый юзер - {}", save.getLogin());
        return true;
    }

    public List<User> userList() {
        return userRepository.findAll();
    }

    public void changeActivity(Long id) {
        User byId = userRepository.findById(id).orElse(null);
        if (byId != null) {
            byId.setActive(!byId.getActive());
            userRepository.save(byId);
        }
    }

}
