package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.dto.UserDTOResponse;
import com.Yury.Food_Delivery.models.User;
import com.Yury.Food_Delivery.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final UserServiceImpl userService;

    @PostMapping("/setUserToActive/{userId}")
    public ResponseEntity<UserDTOResponse> setUserToActive (@PathVariable Long userId){
       return ResponseEntity.ok(userService.setUserToActive(userId));
    }


}
