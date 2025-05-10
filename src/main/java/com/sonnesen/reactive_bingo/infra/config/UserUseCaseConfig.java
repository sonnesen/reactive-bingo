package com.sonnesen.reactive_bingo.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sonnesen.reactive_bingo.application.user.UserGateway;
import com.sonnesen.reactive_bingo.application.user.create.CreateUserUseCase;

@Configuration
public class UserUseCaseConfig {

    @Bean
    CreateUserUseCase createUserUseCase(final UserGateway userRepository) {
        return new CreateUserUseCase(userRepository);
    }
}
