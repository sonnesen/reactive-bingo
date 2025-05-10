package com.sonnesen.reactive_bingo.domain.user;

import java.util.Objects;
import java.util.UUID;

import com.sonnesen.reactive_bingo.infra.persistence.user.UserDocument;

public class User {
    private String id;
    private String name;
    private String email;

    private User(final String id, final String name, final String email) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
    }

    public static User newUser(final String name, final String email) {
        return new User(UUID.randomUUID().toString(), name, email);
    }

    public static User from(final UserDocument savedUser) {
        return new User(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
