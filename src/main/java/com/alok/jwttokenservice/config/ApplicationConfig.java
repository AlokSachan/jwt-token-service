package com.alok.jwttokenservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author asachan@app-scoop.com
 */
@Configuration
@Getter
public class ApplicationConfig {

    @Value(("${oauth.ios.client.id}"))
    private String ClientId;
}
