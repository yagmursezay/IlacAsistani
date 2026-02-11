package com.smartmed.backend.controller;

import com.smartmed.backend.dto.ReminderRequest;
import com.smartmed.backend.model.Reminder;
import com.smartmed.backend.service.ReminderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping("/add")
    public ResponseEntity<Reminder> addReminder(@RequestBody ReminderRequest request) {
        return ResponseEntity.ok(reminderService.createReminder(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Reminder>> getUserReminders(@PathVariable Long userId) {
        return ResponseEntity.ok(reminderService.getUserReminders(userId));
    }
}