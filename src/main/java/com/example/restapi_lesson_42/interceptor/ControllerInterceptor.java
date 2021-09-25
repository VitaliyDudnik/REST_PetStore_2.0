package com.example.restapi_lesson_42.interceptor;

import com.example.restapi_lesson_42.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class ControllerInterceptor implements HandlerInterceptor {
    private final TokenService tokenService;

    public ControllerInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID header = UUID.fromString(request.getHeader("X-Token"));
        boolean existsToken = tokenService.existsToken(header);
        if (existsToken) {
            return true;
        }
        response.sendError(403);
        return false;
    }

}

