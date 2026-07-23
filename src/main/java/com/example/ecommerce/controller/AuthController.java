package com.example.ecommerce.controller;

import com.example.ecommerce.dto.JwtResponse;
import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.RegisterRequest;
import com.example.ecommerce.model.User;
import com.example.ecommerce.security.UserPrincipal;
import com.example.ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    // Test
    @GetMapping("/me")
    public String getCurrentUser(@AuthenticationPrincipal UserPrincipal principal) {
        return "You are logged in as: " + principal.getUsername() + " (" + principal.getUser().getRole() + ")";
    }
}
