package com.example.test.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RsaKeyProprieties.class)
public class AppConfig {
}
