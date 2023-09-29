package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.dto.DistributorDTORequest;
import com.Yury.Food_Delivery.dto.UserDTORequest;
import com.Yury.Food_Delivery.services.Impl.DistributorServiceImpl;
import com.Yury.Food_Delivery.services.Impl.UserServiceImpl;
import com.Yury.Food_Delivery.validation.UserDTOValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
   private final UserServiceImpl userService;
   private final DistributorServiceImpl distributorService;
   private final UserDTOValidation userDTOValidation;

    @PostMapping("/user")
    public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDTORequest userDTO, BindingResult bindingResult){
        Map<String, String> errorMapForFront = new HashMap<>();
        validation(userDTO, bindingResult, errorMapForFront);
        if (!errorMapForFront.isEmpty()){
            return new ResponseEntity<>(errorMapForFront, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    private void validation(UserDTORequest userDTO, BindingResult bindingResult, Map<String, String> errorMapForFront) {
        userDTOValidation.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.stream()
                    .map(error -> errorMapForFront.put(error.getDefaultMessage(), error.getField()))
                    .collect(Collectors.toList());
        }
    }

    @PostMapping("/distributor")
    public ResponseEntity<?> distributorRegistration (@RequestBody @Valid DistributorDTORequest distributorDTO, BindingResult bindingResult){
        Map<String, String> errorMapForFront = new HashMap<>();
        validation(distributorDTO, bindingResult, errorMapForFront);
        if (!errorMapForFront.isEmpty()){
            return new ResponseEntity<>(errorMapForFront, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(distributorService.createDistributor(distributorDTO));
    }
}
