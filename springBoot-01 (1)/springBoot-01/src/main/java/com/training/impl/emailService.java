package com.training.impl;

import com.training.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("email")
@ConditionalOnProperty(name = "notification.type", havingValue = "email")
public class emailService implements NotificationService {

    @Override
    public void send() {
        System.out.println("Email by Email Service");
    }
}
