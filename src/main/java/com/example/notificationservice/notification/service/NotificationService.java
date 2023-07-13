package com.example.notificationservice.notification.service;

import com.example.notificationservice.notification.NotificationRepository;
import com.example.notificationservice.notification.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.net.SocketOption;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final MailSender mailSender;
    private final NotificationRepository notificationRepository;

//    @Autowired
//    public NotificationService(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    public Notification sendEmailNotification(String email, String message) {


        System.out.println(email+message);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Notification");
        mailMessage.setText(message);

        var notificaiton = new Notification();
        notificaiton.setEmail(email);
        notificaiton.setMessage(message);
        notificaiton.setTime(new Date());

        try {
            mailSender.send(mailMessage);
            return notificationRepository.save(notificaiton);
        } catch (MailException e) {
            // Handle any exceptions or log
            Notification not = new Notification();
            not.setMessage("Failedd to set the notification");
            return not;
        }
    }
}
