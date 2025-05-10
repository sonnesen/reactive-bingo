package com.sonnesen.reactive_bingo.infra.api.user;

public record CreateUserResponse(
    String id,
    String name,
    String email
)  {

}
