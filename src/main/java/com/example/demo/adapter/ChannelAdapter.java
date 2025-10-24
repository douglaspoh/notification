package com.example.demo.adapter;

import com.example.demo.dto.NotificationRequest;

public interface ChannelAdapter {
    void send(NotificationRequest notification);
    String getChannelName();
}
