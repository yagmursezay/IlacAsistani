package com.smartmed.backend.repository;

import com.smartmed.backend.model.UserMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserMedicationRepository extends JpaRepository<UserMedication, Long> {
    // Bir kullanıcının tüm ilaçlarını getir
    List<UserMedication> findByUserId(Long userId);
}