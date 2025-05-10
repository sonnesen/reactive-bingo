package com.sonnesen.reactive_bingo.infra.api.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequest(
    @NotEmpty(message = "Name must not be empty")
    String name,
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    String email
)  {

}
