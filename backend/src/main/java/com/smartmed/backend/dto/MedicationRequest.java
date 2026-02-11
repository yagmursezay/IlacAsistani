package com.smartmed.backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MedicationRequest {
    private Long userId;       // İlaç kime ait?
    private String drugName;   // İlacın adı (Örn: Aspirin)
    private String activeIngredient; // Etken madde (Örn: Asetilsalisilik asit)
    private Double dosage;     // Dozaj (Örn: 500 mg)
    private String frequency;  // Kullanım sıklığı (Örn: Sabah-Akşam)
    private LocalDate expiryDate; // Son kullanma tarihi (Örn: 2026-05-20)
}