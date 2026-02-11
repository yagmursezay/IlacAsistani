package com.smartmed.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime remindAt;

    @Enumerated(EnumType.STRING)
    private ReminderStatus status;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private UserMedication medication;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

