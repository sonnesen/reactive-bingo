package com.sonnesen.reactive_bingo.infra.persistence.user;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserDocument, String> {

}
