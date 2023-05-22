package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.Service.GameService;
import com.example.crud.v1.application.dto.GameDto.GameCreateRequest;
import com.example.crud.v1.application.dto.GameDto.GameReadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "https://aribomy.com/*")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public List<GameReadResponse> AllGame(){
        return gameService.getAll();
    }

    @PostMapping("/game/create")
    public Long createGame(@RequestParam GameCreateRequest createRequest){
        return gameService.create(createRequest);
    }

    @DeleteMapping("/game/delete")
    public String deleteGame(@PathVariable(value = "gameName")String gameName){
        return gameService.delete(gameName);
    }

    @GetMapping("/game/GameTitle")
    public List findByGame(@PathVariable(value = "gameTitle")String gameTitle){
        return gameService.findByGameTitle(gameTitle);
    }
}
