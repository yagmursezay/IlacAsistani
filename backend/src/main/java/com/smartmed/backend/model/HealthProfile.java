package com.smartmed.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "health_profiles")
public class HealthProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private double weight;
    private String bloodType;

    @ElementCollection
    private List<String> chronicDiseases;

    @ElementCollection
    private List<String> allergies;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}