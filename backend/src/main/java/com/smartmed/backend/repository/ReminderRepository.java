package com.smartmed.backend.repository;

import com.smartmed.backend.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    // Bir kullanıcının tüm alarmlarını getir
    List<Reminder> findByUserId(Long userId);

    // Sadece vadesi gelmiş ama henüz "İçtim" denmemiş alarmları bul (İleride lazım olacak)
    // List<Reminder> findByUserIdAndStatus(Long userId, ReminderStatus status);
}