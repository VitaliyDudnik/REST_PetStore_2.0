package com.example.restapi_lesson_42.service;

import com.example.restapi_lesson_42.entity.Token;
import com.example.restapi_lesson_42.repository.TokenRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token save(Token token) {
        return tokenRepository.save(token);
    }

   public boolean existsToken(UUID token) {
        return tokenRepository.existsTokenByUuid(token);
    }

    public Optional<Token> findTokenByUUID(UUID token){
        return tokenRepository.findByUuid(token);
    }

    public void delete(Token token){
        tokenRepository.delete(token);
    }
}
