package com.example.notificationservice.notification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;


@Data
public class notificationDto implements Serializable {



    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String message;

    private String time;
}