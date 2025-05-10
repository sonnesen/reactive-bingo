package com.sonnesen.reactive_bingo.infra.api.user;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.sonnesen.reactive_bingo.application.user.create.CreateUserInput;
import com.sonnesen.reactive_bingo.application.user.create.CreateUserUseCase;

import reactor.core.publisher.Mono;

@RestController
public class UserController implements UserApi {

    private final CreateUserUseCase createUserUseCase;

    public UserController(final CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = Objects.requireNonNull(createUserUseCase, "createUserUseCase must not be null");
    }

    @Override
    public Mono<ResponseEntity<CreateUserResponse>> createUser(final CreateUserRequest request,
                                                               final ServerWebExchange exchange) {
        return createUserUseCase.execute(new CreateUserInput(request.name(), request.email()))
                .map(output -> new CreateUserResponse(output.id(), output.name(), output.email()))
                .map(output -> ResponseEntity.created(exchange.getRequest().getURI())
                        .body(output));
    }

}
