package com.smartmed.backend.controller;

import com.smartmed.backend.dto.MedicationRequest;
import com.smartmed.backend.model.UserMedication;
import com.smartmed.backend.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserMedication> addMedication(@RequestBody MedicationRequest request) {
        return ResponseEntity.ok(medicationService.addMedication(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserMedication>> getUserMedications(@PathVariable Long userId) {
        return ResponseEntity.ok(medicationService.getUserMedications(userId));
    }
}