package com.smartmed.backend.repository;

import com.smartmed.backend.model.HealthProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HealthProfileRepository extends JpaRepository<HealthProfile, Long> {
    // Bir kullanıcının sağlık profilini bulmak için özel komut
    Optional<HealthProfile> findByUserId(Long userId);
}