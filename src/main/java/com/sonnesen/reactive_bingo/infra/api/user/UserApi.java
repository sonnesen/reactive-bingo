package com.sonnesen.reactive_bingo.infra.api.user;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RequestMapping("/api/v1/users")
@Validated
public interface UserApi {

    @PostMapping
    Mono<ResponseEntity<CreateUserResponse>> createUser(@RequestBody @Valid CreateUserRequest request,
                                                        final ServerWebExchange exchange);
}
