package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.dto.UserDto.UserCreateRequest;
import com.example.crud.v1.application.dto.UserDto.UserReadResponse;
import com.example.crud.v1.domain.User;
import com.example.crud.v1.presentation.http.util.GoogleIDTokenResolver;
import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import com.example.crud.v1.application.Service.UserService;
import com.example.crud.v1.presentation.http.util.TokenResponse;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "https://aribomy.com/*")
public class UserController {
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/oauth/google/callback")
    public TokenResponse googleLogin(HttpServletResponse response, String code) throws Exception {
        UserCreateRequest userCreateRequest = GoogleIDTokenResolver.resolve(code);
        Optional<User> userOptional = userService.findUser(userCreateRequest.getEmail());   //userOptional 변수를 만들어서 Optional<User>를 체크
        User user = null;
        if(userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            user = userService.register(userCreateRequest);
        }

        ResponseCookie cookie = ResponseCookie.from("userInfo", this.jwtTokenProvider.createToken(user.getId()))
                .httpOnly(false)
                .secure(true)
                .path("/")
                .maxAge(Duration.ofSeconds(3600))
                .sameSite("Lax")
                .build();

        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return new TokenResponse(this.jwtTokenProvider.createToken(user.getId()), "cookie");
    }

    @GetMapping("/sign-out")
    public ResponseEntity<String> Logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("userInfo", null);
        cookie.setMaxAge(0); // 쿠키 유효시간 설정 (1시간)
        cookie.setPath("/"); // 쿠키 경로 설정 (루트 경로)
        response.addCookie(cookie); // 쿠키 추가
        return ResponseEntity.ok("sign-out");
    }

    @DeleteMapping("/remove/{userId}")
    public Long remove (@PathVariable(value = "userId") Long id){
        return userService.delete(id);
    }
}
