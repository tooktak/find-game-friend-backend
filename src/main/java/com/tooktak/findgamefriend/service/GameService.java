package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.service.dto.game.GameCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService (GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Game create(GameCreateRequest req){
        Game game = new Game(req.getTitle(), req.getThumbnailURL());
        return gameRepository.save(game);
    }
}
