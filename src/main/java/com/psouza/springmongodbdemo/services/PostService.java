package com.psouza.springmongodbdemo.services;

import com.psouza.springmongodbdemo.entities.Post;
import com.psouza.springmongodbdemo.repositories.PostRepository;
import com.psouza.springmongodbdemo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        return repository.fullSearch(text, minDate, maxDate);
    }
}
