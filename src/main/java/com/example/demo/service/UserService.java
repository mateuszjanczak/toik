package com.example.demo.service;

import com.example.demo.repository.Type;
import com.example.demo.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public Type checkLogin(String login, String password) {
        return this.userRepository.checkLogin(login, password);
    }

}
