package com.smartmed.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReminderRequest {
    private Long userId;       // Kimin için?
    private Long medicationId; // Hangi ilaç için?
    private LocalDateTime remindAt; // Ne zaman çalsın? (Yıl-Ay-Gün Saat:Dakika)
}