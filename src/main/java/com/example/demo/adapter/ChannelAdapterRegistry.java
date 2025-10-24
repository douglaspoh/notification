package com.example.demo.adapter;

import com.example.demo.config.NotificationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ConfigurationProperties(prefix = "notification")
public class ChannelAdapterRegistry {

    private final Map<String, ChannelAdapter> adaptersList;
    private final NotificationProperties notificationProperties;

    @Autowired
    ChannelAdapterRegistry(List<ChannelAdapter> adapters, NotificationProperties notificationProperties) {
        this.adaptersList = new ConcurrentHashMap<>();
        this.notificationProperties = notificationProperties;

        for(ChannelAdapter adapter: adapters) {
            if(notificationProperties.getEnabledChannel(adapter.getChannelName())) {
                adaptersList.put(adapter.getChannelName(), adapter);
            }
        }
        System.out.println("Registered channels: " + adaptersList.keySet());
    }

    public ChannelAdapter getChannelAdapter(String channelType) {
        ChannelAdapter adapter = adaptersList.get(channelType);
        if(adapter == null) {
            throw new IllegalArgumentException("Unsupported channel: " + channelType);
        }
        return adapter;
    }
}
