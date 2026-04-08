package com.training.impl;

import com.training.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Primary
@Component
@Qualifier("sms")
@ConditionalOnProperty(name = "notification.type", havingValue = "sms")
public class smsService implements NotificationService {

    public void send() {
        System.out.println("SMS By SMS Service");
    }


}
