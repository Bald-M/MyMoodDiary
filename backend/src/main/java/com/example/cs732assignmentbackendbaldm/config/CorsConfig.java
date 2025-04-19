package com.example.cs732assignmentbackendbaldm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global CORS configuration for Spring Boot application
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * Configure CORS mappings for all endpoints
     * @param registry CORS registry to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all paths
                .allowedOriginPatterns("*") // Allow all frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Supported HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true) // Allow cookies/credentials
                .maxAge(3600); // Pre-flight cache
    }
}