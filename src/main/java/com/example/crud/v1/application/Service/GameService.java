package com.example.crud.v1.application.Service;

import com.example.crud.v1.application.dto.GameDto.GameCreateRequest;
import com.example.crud.v1.application.dto.GameDto.GameReadResponse;
import com.example.crud.v1.domain.Game;
import com.example.crud.v1.infrastructure.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameReadResponse> getAll(){

        return gameRepository.findAll().stream().map(p->GameReadResponse.fromEntity(p)).collect(Collectors.toList());
    }

    public Long create (final GameCreateRequest create){
        Game game = new Game(create.getTitle(),create.getThumbnailURL());
        gameRepository.save(game);
        return gameRepository.save(game).getId();
    }

    public String delete (final String gameName){
        Game game = gameRepository.getByTitle(gameName);
        gameRepository.delete(game);
        return game.getTitle();
    }

    public List<Game> findByGameName(final String gameName){
        List<Game> games = gameRepository.findByTitle(gameName);
        return games;
    }

    public GameReadResponse getGame(final Long id){
        return GameReadResponse.fromEntity(gameRepository.getById(id));
    }
}