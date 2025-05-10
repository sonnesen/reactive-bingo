package com.sonnesen.reactive_bingo.application.user.create;

import com.sonnesen.reactive_bingo.domain.user.User;

public record CreateUserOutput(
    String id,
    String name,
    String email
) {
     public static CreateUserOutput from(final User user) {
            return new CreateUserOutput(user.getId(), user.getName(), user.getEmail());
        }
}
