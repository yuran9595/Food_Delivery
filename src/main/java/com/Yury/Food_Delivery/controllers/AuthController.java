package com.Yury.Food_Delivery.controllers;

import com.Yury.Food_Delivery.dto.JwtRequestDto;
import com.Yury.Food_Delivery.dto.JwtResponseDto;
import com.Yury.Food_Delivery.exeptions.NotValidCredentials;
import com.Yury.Food_Delivery.services.CustomUserDetailsService;
import com.Yury.Food_Delivery.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenUtils jwtTokenUtils;

    @PostMapping("/auth")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<?> createToken(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestDto.getUsername()
                    ,jwtRequestDto.getPassword()));
        }catch (BadCredentialsException e) {
            return new ResponseEntity<>(new NotValidCredentials(HttpStatus.UNAUTHORIZED.value(), "Wrong credentials")
                    , HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequestDto.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}
