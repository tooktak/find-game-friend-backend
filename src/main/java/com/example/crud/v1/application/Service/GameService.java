package com.example.crud.v1.application.Service;

import com.example.crud.v1.application.dto.GameDto.GameCreateRequest;
import com.example.crud.v1.domain.Game;
import com.example.crud.v1.infrastructure.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Long create (final GameCreateRequest create){
        Game game = new Game(create.getGameName(),create.getThumbNail());
        gameRepository.save(game);
        return gameRepository.save(game).getId();
    }

    public String delete (final String gameName){
        Game game = gameRepository.getByGameName(gameName);
        gameRepository.delete(game);
        return game.getGameName();
    }

    public List<Game> findByGameName(final String gameName){
        List<Game> games = gameRepository.findByGameName(gameName);
        return games;
    }
}