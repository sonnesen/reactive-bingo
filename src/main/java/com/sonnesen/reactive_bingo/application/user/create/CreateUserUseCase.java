package com.sonnesen.reactive_bingo.application.user.create;

import java.util.Objects;

import com.sonnesen.reactive_bingo.application.user.UserGateway;
import com.sonnesen.reactive_bingo.domain.user.User;

import reactor.core.publisher.Mono;

public class CreateUserUseCase {

    private final UserGateway userRepository;

    public CreateUserUseCase(final UserGateway userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository, "userRepository must not be null");
    }

    public Mono<CreateUserOutput> execute(final CreateUserInput input) {
        final var user = User.newUser(input.name(), input.email());
        return userRepository.save(user)
                .map(CreateUserOutput::from);
    }
}
