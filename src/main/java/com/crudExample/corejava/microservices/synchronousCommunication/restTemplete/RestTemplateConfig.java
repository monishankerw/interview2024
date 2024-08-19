package com.crudExample.corejava.microservices.synchronousCommunication.restTemplete;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(java.time.Duration.ofMillis(3000))
                .setReadTimeout(java.time.Duration.ofMillis(3000))
                .build();
    }
}
