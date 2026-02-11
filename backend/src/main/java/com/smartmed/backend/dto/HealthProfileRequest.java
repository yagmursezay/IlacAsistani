package com.smartmed.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class HealthProfileRequest {
    // Kullanıcıdan sadece bu bilgileri isteyeceğiz
    private Long userId; // Hangi kullanıcı için?
    private int age;
    private double weight;
    private String bloodType;
    private List<String> chronicDiseases; // Kronik hastalıklar listesi
    private List<String> allergies;       // Alerjiler listesi
}