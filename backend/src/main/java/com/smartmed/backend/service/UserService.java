package com.smartmed.backend.service;

import com.smartmed.backend.model.User;
import com.smartmed.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Depo görevlisini (Repository) çağırıyoruz
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // 1. Kontrol: Bu e-posta ile daha önce kayıt olunmuş mu?
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Bu email adresi zaten kullanımda!");
        }

        // 2. İşlem: Yoksa kullanıcıyı veritabanına kaydet
        return userRepository.save(user);
    }
    // Giriş yapma işlemi
    public User loginUser(String email, String password) {
        // 1. Veritabanında bu mail ile biri var mı?
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        // 2. Şifre eşleşiyor mu? (Şimdilik basit kontrol yapıyoruz)
        if (!user.getPasswordHash().equals(password)) {
            throw new RuntimeException("Şifre hatalı!");
        }

        // 3. Her şey doğruysa kullanıcıyı geri döndür
        return user;
    }
}