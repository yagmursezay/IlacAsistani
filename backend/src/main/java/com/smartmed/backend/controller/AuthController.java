package com.smartmed.backend.controller;

import com.smartmed.backend.model.User;
import com.smartmed.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Postman'den gelen kayıt isteğini karşılayan kapı
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }
    // Giriş yapma kapısı
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // Service'e "Bu bilgileri kontrol et" diyoruz
        User loggedInUser = userService.loginUser(user.getEmail(), user.getPasswordHash());
        return ResponseEntity.ok(loggedInUser);
    }
}