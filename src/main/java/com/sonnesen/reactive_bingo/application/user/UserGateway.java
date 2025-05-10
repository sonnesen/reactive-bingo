package com.sonnesen.reactive_bingo.application.user;

import com.sonnesen.reactive_bingo.domain.user.User;

import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> save(User user);
}
