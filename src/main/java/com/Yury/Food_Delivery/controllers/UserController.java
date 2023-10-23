package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.dto.UserDTOResponse;
import com.Yury.Food_Delivery.models.User;
import com.Yury.Food_Delivery.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserServiceImpl userService;

   // @RequestMapping(value = "/getUserList",  method = {RequestMethod.OPTIONS, RequestMethod.GET})
    @GetMapping("/getUserList")
    public List<UserDTOResponse> userList(Principal principal){
        return userService.userList();
    }
}
