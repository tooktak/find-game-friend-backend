package com.example.crud.v1.presentation;

import com.example.crud.v1.application.Service.GameService;
import com.example.crud.v1.application.dto.GameDto.GameCreateRequest;
import com.example.crud.v1.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game/create")
    public Long createGame(@RequestParam GameCreateRequest createRequest){
        return gameService.create(createRequest);
    }

    @DeleteMapping("/game/delete")
    public String deleteGame(@PathVariable(value = "gameName")String gameName){
        return gameService.delete(gameName);
    }

    @GetMapping("/post/GameTitle")
    public List<Game> findByGame(@PathVariable(value = "gameTitle")String gameTitle){
        return gameService.findByGameName(gameTitle);
    }

}
