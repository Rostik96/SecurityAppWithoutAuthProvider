package com.rost.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rost.models.Principal;
import com.rost.repositories.PrincipalRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PrincipalRepository principalRepository;

    public List<Principal> readAll() {
        return principalRepository.findAll();
    }
}
