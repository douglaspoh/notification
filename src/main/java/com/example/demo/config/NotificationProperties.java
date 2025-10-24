package com.example.demo.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "notification")
@Setter
public class NotificationProperties {
    private Map<String, Boolean> enabledChannels;

    public Boolean getEnabledChannel(String channelType) {
        return enabledChannels.getOrDefault(channelType, false);
    }
}
