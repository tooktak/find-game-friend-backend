package com.tooktak.findgamefriend.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public")
public class EmptyController {

    @GetMapping("/home")
    public String home() {
        return "Hello World2";
    }
}
