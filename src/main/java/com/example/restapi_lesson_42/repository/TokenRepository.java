package com.example.restapi_lesson_42.repository;

import com.example.restapi_lesson_42.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, Long> {
    boolean existsTokenByUuid(UUID token);

    Optional<Token> findByUuid(UUID token);

}
