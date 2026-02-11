package com.smartmed.backend.service;

import com.smartmed.backend.dto.ReminderRequest;
import com.smartmed.backend.model.Reminder;
import com.smartmed.backend.model.ReminderStatus;
import com.smartmed.backend.model.User;
import com.smartmed.backend.model.UserMedication;
import com.smartmed.backend.repository.ReminderRepository;
import com.smartmed.backend.repository.UserMedicationRepository;
import com.smartmed.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final UserRepository userRepository;
    private final UserMedicationRepository medicationRepository;

    public ReminderService(ReminderRepository reminderRepository, UserRepository userRepository, UserMedicationRepository medicationRepository) {
        this.reminderRepository = reminderRepository;
        this.userRepository = userRepository;
        this.medicationRepository = medicationRepository;
    }

    public Reminder createReminder(ReminderRequest request) {
        // 1. Kullanıcıyı bul
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        // 2. İlacı bul
        UserMedication medication = medicationRepository.findById(request.getMedicationId())
                .orElseThrow(() -> new RuntimeException("İlaç bulunamadı!"));

        // 3. Alarmı kur
        Reminder reminder = new Reminder();
        reminder.setUser(user);
        reminder.setMedication(medication);
        reminder.setRemindAt(request.getRemindAt());
        reminder.setStatus(ReminderStatus.BEKLIYOR); // Varsayılan durum: Bekliyor

        return reminderRepository.save(reminder);
    }

    public List<Reminder> getUserReminders(Long userId) {
        return reminderRepository.findByUserId(userId);
    }
}