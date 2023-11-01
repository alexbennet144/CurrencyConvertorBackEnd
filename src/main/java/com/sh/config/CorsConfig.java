package com.sh.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from your React application's origin
        config.setAllowedOrigins(Collections.singletonList("http://localhost:3000")); // Replace with your React app's origin

        // You can also configure other CORS options here if needed

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
