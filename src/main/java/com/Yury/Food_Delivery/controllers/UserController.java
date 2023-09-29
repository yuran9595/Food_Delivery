package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.models.User;
import com.Yury.Food_Delivery.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/getUserList")
    public List<User> userList(Principal principal){
        return userService.userList();
    }
}
