package com.example.notificationservice.notification;

import com.example.notificationservice.notification.model.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String>, JpaSpecificationExecutor<Notification> {

	Optional<Notification> findByEmailOrderByTimeDesc(String email);

}