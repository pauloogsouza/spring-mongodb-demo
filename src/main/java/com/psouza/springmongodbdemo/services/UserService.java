package com.psouza.springmongodbdemo.services;

import com.psouza.springmongodbdemo.entities.User;
import com.psouza.springmongodbdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
