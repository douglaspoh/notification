package com.example.demo.adapter;

import com.example.demo.dto.NotificationRequest;
import org.springframework.stereotype.Component;

@Component
public class EmailAdapter implements ChannelAdapter {

    @Override
    public void send(NotificationRequest notification) {
        System.out.println("In email adapter");
    }

    @Override
    public String getChannelName() {
       return "email";
    }
}
