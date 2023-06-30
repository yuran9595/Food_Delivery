package com.Yury.Food_Delivery.repository;

import com.Yury.Food_Delivery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
