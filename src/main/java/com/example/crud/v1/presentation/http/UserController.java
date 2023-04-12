package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.dto.UserDto.UserCreateRequest;
import com.example.crud.v1.domain.User;
import com.example.crud.v1.presentation.http.util.GoogleIDTokenResolver;
import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import com.example.crud.v1.application.Service.UserService;
import com.example.crud.v1.presentation.http.util.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@RestController
public class UserController {
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping("/oauth/google/callback")
    public TokenResponse googleLogin(String code) throws Exception {
        UserCreateRequest userCreateRequest = GoogleIDTokenResolver.resolve(code);
        // return JWT if exists user
        Optional<User> user = userService.findUser(userCreateRequest.getEmail());
        if (user.isPresent()) {
            return new TokenResponse(this.jwtTokenProvider.createToken(user.get().getId()), "bearer");
        }
        User newUser = userService.register(userCreateRequest);
        // create new user and return JWT if non-exists user
        return new TokenResponse(this.jwtTokenProvider.createToken(newUser.getId()), "bearer");
    }*/
    @GetMapping("/oauth/google/callback")
    public TokenResponse googleLogin(HttpServletResponse response, String code) throws Exception {
        UserCreateRequest userCreateRequest = GoogleIDTokenResolver.resolve(code);
        // return JWT if exists user
        Optional<User> user = userService.findUser(userCreateRequest.getEmail());
        if (user.isPresent()) {
            Cookie cookie = new Cookie("userInfo", this.jwtTokenProvider.createToken(user.get().getId()));
            cookie.setMaxAge(3600); // 쿠키 유효시간 설정 (1시간)
            cookie.setPath("/"); // 쿠키 경로 설정 (루트 경로)
            cookie.setHttpOnly(true); // HttpOnly 설정
            response.addCookie(cookie); // 쿠키 추가
            return new TokenResponse(this.jwtTokenProvider.createToken(user.get().getId()), "cookie");
        }
        User newUser = userService.register(userCreateRequest);
        // create new user and return JWT if non-exists user
        Cookie cookie = new Cookie("userInfo", this.jwtTokenProvider.createToken(user.get().getId()));
        cookie.setMaxAge(3600); // 쿠키 유효시간 설정 (1시간)
        cookie.setPath("/"); // 쿠키 경로 설정 (루트 경로)
        cookie.setHttpOnly(true); // HttpOnly 설정
        response.addCookie(cookie); // 쿠키 추가
        return new TokenResponse(this.jwtTokenProvider.createToken(newUser.getId()), "cookie");
    }

    @GetMapping("/sign-out")
    public ResponseEntity<String> Logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("userInfo", null);
        cookie.setMaxAge(0); // 쿠키 유효시간 설정 (1시간)
        cookie.setPath("/"); // 쿠키 경로 설정 (루트 경로)
        cookie.setHttpOnly(true); // HttpOnly 설정
        response.addCookie(cookie); // 쿠키 추가
        return ResponseEntity.ok("sign-out");
    }
}
