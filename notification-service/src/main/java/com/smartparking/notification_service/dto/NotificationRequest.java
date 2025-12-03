package com.smartparking.notification_service.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private String to;
    private String message;
    private String type; // EMAIL, SMS, PUSH
}
