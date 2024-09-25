package com.nus.iss.tasktracker.config;

import com.nus.iss.tasktracker.interceptor.TaskTrackerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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


}