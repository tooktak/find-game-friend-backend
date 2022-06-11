package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.service.GameService;
import com.tooktak.findgamefriend.service.dto.game.GameCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService= gameService;
    }

    @PostMapping("/game")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void GameCreate(@RequestBody GameCreateRequest gameCreateRequest) {
        gameService.create(gameCreateRequest);
    }
}
