package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public")
public class EmptyController {
    private final GameService gameService;

    @Autowired
    public EmptyController(GameService gameService) {
        this.gameService= gameService;
    }

    @GetMapping("/home")
    public String home() {
        Game game = this.gameService.save();
        return game.getThumbnailURL();
    }
}
