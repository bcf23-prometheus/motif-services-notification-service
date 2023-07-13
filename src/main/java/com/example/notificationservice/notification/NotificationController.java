package com.example.notificationservice.notification;

import com.example.notificationservice.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notifications")
    public ResponseEntity<String> sendNotification(@RequestBody Notification notification) {
        notificationService.sendEmailNotification(notification.getEmail(), notification.getMessage());
        return new ResponseEntity<>("Notification sent", HttpStatus.OK);
    }
}
