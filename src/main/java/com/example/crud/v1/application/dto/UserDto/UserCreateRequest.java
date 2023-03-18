package com.example.crud.v1.application.dto.UserDto;

import com.example.crud.v1.domain.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCreateRequest {
    private String email;
    private String password;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return new User(this.email, this.password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
