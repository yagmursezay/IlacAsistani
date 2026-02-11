package com.smartmed.backend.controller;

import com.smartmed.backend.dto.HealthProfileRequest;
import com.smartmed.backend.model.HealthProfile;
import com.smartmed.backend.service.HealthProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class HealthProfileController {

    private final HealthProfileService healthProfileService;

    public HealthProfileController(HealthProfileService healthProfileService) {
        this.healthProfileService = healthProfileService;
    }

    // Profil oluşturma veya güncelleme kapısı
    @PostMapping("/save")
    public ResponseEntity<HealthProfile> saveProfile(@RequestBody HealthProfileRequest request) {
        return ResponseEntity.ok(healthProfileService.createOrUpdateProfile(request));
    }

    // Profil görüntüleme kapısı
    @GetMapping("/{userId}")
    public ResponseEntity<HealthProfile> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(healthProfileService.getProfile(userId));
    }
}