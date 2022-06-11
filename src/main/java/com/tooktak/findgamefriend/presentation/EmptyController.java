package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.domain.User;
import com.tooktak.findgamefriend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public")
@RequiredArgsConstructor
public class EmptyController {
    private final UserService userService;

    @GetMapping("/home")
    public String home() {
        User user = this.userService.save();

        return user.getEmail();
    }
}
