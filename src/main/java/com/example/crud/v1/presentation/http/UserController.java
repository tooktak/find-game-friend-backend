package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.dto.UserDto.UserCreateRequest;
import com.example.crud.v1.domain.User;
import com.example.crud.v1.presentation.http.util.GoogleIDTokenResolver;
import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import com.example.crud.v1.presentation.http.util.TokenResponse;
import com.example.crud.v1.application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/oauth/google/callback")
    public TokenResponse googleLogin(String code) throws Exception {
        UserCreateRequest userCreateRequest = GoogleIDTokenResolver.resolve(code);
        // return JWT if exists user
        Optional<User> user = userService.findUser(userCreateRequest.getEmail());
        if (user.isPresent()) {
            return new TokenResponse(this.jwtTokenProvider.createToken(user.get().getId()), "test");
        }
        // create new user and return JWT if non-exists user
        return new TokenResponse(
                this.jwtTokenProvider.createToken(
                        userService.register(
                                userCreateRequest
                        ).getId()
                ),
                "test"
        );
    }
}
