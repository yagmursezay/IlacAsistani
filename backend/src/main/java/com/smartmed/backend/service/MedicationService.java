package com.smartmed.backend.service;

import com.smartmed.backend.dto.MedicationRequest;
import com.smartmed.backend.model.User;
import com.smartmed.backend.model.UserMedication;
import com.smartmed.backend.repository.UserMedicationRepository;
import com.smartmed.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    private final UserMedicationRepository medicationRepository;
    private final UserRepository userRepository;

    public MedicationService(UserMedicationRepository medicationRepository, UserRepository userRepository) {
        this.medicationRepository = medicationRepository;
        this.userRepository = userRepository;
    }

    public UserMedication addMedication(MedicationRequest request) {
        // 1. Kullanıcıyı bul
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));
// ---------------------------------------------------------------
        // 🚧 GELECEKTEKİ AI KAPISI:
        // Burada yapay zeka servisini çağıracağız.
        // Örn: aiService.analizEt(user.getHealthProfile(), request.getActiveIngredient());
        // Eğer risk varsa kullanıcıya uyarı döneceğiz.
        // ---------------------------------------------------------------

        // 2. İlaç kaydını oluştur
        UserMedication medication = new UserMedication();
        medication.setUser(user);
        medication.setDrugName(request.getDrugName());
        medication.setActiveIngredient(request.getActiveIngredient());
        medication.setDosage(request.getDosage());
        medication.setFrequency(request.getFrequency());
        medication.setExpiryDate(request.getExpiryDate());

        // 3. Kaydet
        return medicationRepository.save(medication);
    }

    public List<UserMedication> getUserMedications(Long userId) {
        return medicationRepository.findByUserId(userId);
    }
}