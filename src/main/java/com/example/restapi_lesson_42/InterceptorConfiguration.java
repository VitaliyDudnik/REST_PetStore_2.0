package com.example.restapi_lesson_42;

import com.example.restapi_lesson_42.interceptor.ControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
    private final ControllerInterceptor controllerInterceptor;

    public InterceptorConfiguration(ControllerInterceptor controllerInterceptor) {
        this.controllerInterceptor = controllerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(controllerInterceptor)
                .addPathPatterns("/user/login", "/user/logout");

    }
}
