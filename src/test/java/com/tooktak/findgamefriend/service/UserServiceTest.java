package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.User;
import com.tooktak.findgamefriend.service.dto.user.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.config.location=classpath:application-test.yaml"})
class UserServiceTest {
    @Autowired private UserService userService;
    @Test
    void register() {
        User user = userService.register(new UserRegisterRequest("qwe123","qweqwe123","qwe23@gmail.com","ewq123","tktktkriifooq12weq"));
        assert user.getUserId() == "qwe123";
        assert user.getPassword() == "qweqwe123";
        assert user.getEmail() == "qwe23@gmail.com";
        assert user.getNickName() == "ewq123";
        assert user.getPictureURL() == "tktktkriifooq12weq";
    }
}