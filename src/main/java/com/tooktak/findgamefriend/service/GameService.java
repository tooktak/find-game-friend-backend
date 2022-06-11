package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
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

    public Game save(){
        Game game = new Game("helloGame","ttoorffgjkjieweruiweur123ouiodglfjdfior1");
        gameRepository.save(game);
        return gameRepository.getBythumbnail("ttoorffgjkjieweruiweur123ouiodglfjdfior1");
    }
}
