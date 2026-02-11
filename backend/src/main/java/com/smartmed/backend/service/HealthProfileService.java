package com.smartmed.backend.service;

import com.smartmed.backend.dto.HealthProfileRequest;
import com.smartmed.backend.model.HealthProfile;
import com.smartmed.backend.model.User;
import com.smartmed.backend.repository.HealthProfileRepository;
import com.smartmed.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class HealthProfileService {

    private final HealthProfileRepository healthProfileRepository;
    private final UserRepository userRepository;

    public HealthProfileService(HealthProfileRepository healthProfileRepository, UserRepository userRepository) {
        this.healthProfileRepository = healthProfileRepository;
        this.userRepository = userRepository;
    }

    public HealthProfile createOrUpdateProfile(HealthProfileRequest request) {
        // 1. Önce kullanıcıyı bulalım
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        // 2. Bu kullanıcının zaten bir profili var mı? Varsa onu güncelle, yoksa yeni yap.
        HealthProfile profile = healthProfileRepository.findByUserId(request.getUserId())
                .orElse(new HealthProfile());

        // 3. Bilgileri doldur
        profile.setUser(user);
        profile.setAge(request.getAge());
        profile.setWeight(request.getWeight());
        profile.setBloodType(request.getBloodType());
        profile.setChronicDiseases(request.getChronicDiseases());
        profile.setAllergies(request.getAllergies());

        // 4. Kaydet
        return healthProfileRepository.save(profile);
    }

    // Profili görüntülemek için metod
    public HealthProfile getProfile(Long userId) {
        return healthProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profil bulunamadı!"));
    }
}