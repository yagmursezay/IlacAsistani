package com.smartmed.backend.repository;

import com.smartmed.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // E-posta ile kullanıcı bul (Giriş yaparken lazım)
    Optional<User> findByEmail(String email);

    // Bu e-posta daha önce alınmış mı? (Kayıt olurken lazım)
    boolean existsByEmail(String email);
}