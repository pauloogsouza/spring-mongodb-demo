package com.psouza.springmongodbdemo.repositories;

import com.psouza.springmongodbdemo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
