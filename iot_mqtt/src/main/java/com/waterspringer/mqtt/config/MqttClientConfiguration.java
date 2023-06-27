package com.waterspringer.mqtt.config;

import com.waterspringer.mqtt.entity.EmqxClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttClientConfiguration {

    @Autowired
    private MqttConfig mqttConfig;


    @Bean
    EmqxClient mqttClient(){
        EmqxClient client = new EmqxClient();
        client.setClientId(mqttConfig.getClientId());
        client.setUsername(mqttConfig.getUsername());
        client.setPassword(mqttConfig.getPassword());
        client.setHostname(mqttConfig.getHostUrl());
        client.setTimeout(mqttConfig.getTimeout());
        client.setKeepalive(mqttConfig.getKeepalive());
        client.setClearSession(mqttConfig.isClearSession());
        return client;
    }
}
