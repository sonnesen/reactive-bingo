package com.sonnesen.reactive_bingo.infra.persistence.user;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.sonnesen.reactive_bingo.application.user.UserGateway;
import com.sonnesen.reactive_bingo.domain.user.User;

import reactor.core.publisher.Mono;

@Component
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    public UserGatewayImpl(final UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository, "userRepository must not be null");
    }

    @Override
    public Mono<User> save(final User user) {
        final var userToSave = new UserDocument(user.getId(), user.getName(), user.getEmail());
        return userRepository.save(userToSave)
                .map(savedUser -> User.from(savedUser));
    }

}
