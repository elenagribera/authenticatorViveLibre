package com.example.authenticatorservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "auth.service")
@Getter
@Setter
public class AuthenticatorViveLibreConfiguration {
    private String url;
    private String username;
    private String password;

}
