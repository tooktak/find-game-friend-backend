package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.User;
import com.tooktak.findgamefriend.service.FindMatePostService;
import com.tooktak.findgamefriend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public")
@RequiredArgsConstructor
public class EmptyController {
    private final FindMatePostService findMatePostService;

    @GetMapping("/home")
    public String home() {
        FindMatePost findMatePost = this.findMatePostService.save();

        return findMatePost.getTitle();
    }
}
