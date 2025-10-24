package com.example.demo.service;

import com.example.demo.adapter.ChannelAdapter;
import com.example.demo.adapter.ChannelAdapterRegistry;
import com.example.demo.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final ChannelAdapterRegistry registry;

    public void sendNotification(NotificationRequest notification) {
        ChannelAdapter adapter = registry.getChannelAdapter(notification.getChannel());
        adapter.send(notification);
    }
}
