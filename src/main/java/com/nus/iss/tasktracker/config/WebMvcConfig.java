package com.nus.iss.tasktracker.config;

import com.nus.iss.tasktracker.interceptor.TaskTrackerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    private final TaskTrackerInterceptor taskTrackerInterceptor;

    @Autowired
    public WebMvcConfig(TaskTrackerInterceptor taskTrackerInterceptor) {
        this.taskTrackerInterceptor = taskTrackerInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(taskTrackerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login"); // Exclude specific URL pattern
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://localhost:3000") // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow necessary HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true) // If your request includes cookies or authentication
                .maxAge(3600); // Cache the preflight response for 1 hour
    }

}