package com.smartparking.notification_service.service;

import com.smartparking.notification_service.dto.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class NotificationService {

    @Autowired
    private WebClient webClient;

    public void sendNotification(NotificationRequest request) {
        // Log interne
        log.info("Sending {} notification to {}: {}",
                request.getType(),
                request.getTo(),
                request.getMessage());

        // Appel à un service externe via WebClient
        webClient.post()
                .uri("/notifications") // Endpoint sur l'API externe
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(
                        response -> log.info("Notification sent successfully: {}", response),
                        error -> log.error("Error sending notification: {}", error.getMessage())
                );
    }
}
