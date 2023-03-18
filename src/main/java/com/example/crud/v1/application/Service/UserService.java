package com.example.crud.v1.application.Service;

import com.example.crud.v1.application.dto.UserDto.UserCreateRequest;
import com.example.crud.v1.domain.User;
import com.example.crud.v1.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    public User register(UserCreateRequest userCreateRequest) {
        return this.userRepository.save(userCreateRequest.toEntity());
    }
}
