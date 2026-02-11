package com.smartmed.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role; // HASTA veya YONETICI

    // İlişki: Bir kullanıcının bir sağlık profili olur
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private HealthProfile healthProfile;
}

// Rolleri de buraya ekleyelim
enum Role {
    HASTA,
    YONETICI
}