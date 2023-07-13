package com.example.notificationservice.notification.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name ="notification", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {



    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column (nullable = false)
    private String message;

    @Column (nullable = false)
    private Date time;

    @Column (nullable = false)
    private String email;
}
