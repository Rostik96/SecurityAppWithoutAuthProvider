package com.rost.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rost.models.User;
import com.rost.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> readAll() {
        return userRepository.findAll();
    }
}
