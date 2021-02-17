package com.psouza.springmongodbdemo.repositories;

import com.psouza.springmongodbdemo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
