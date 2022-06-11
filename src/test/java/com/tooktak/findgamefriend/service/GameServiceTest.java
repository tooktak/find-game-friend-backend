package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.service.dto.game.GameCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// integration test 수행 시 'SpringBootTest'를 사용해야 함.
@SpringBootTest(properties = {"spring.config.location=classpath:application-test.yaml"})
class GameServiceTest {
    @Autowired private GameService gameService;

    @Test
    public void CreateTest() {
        Game game = gameService.create(new GameCreateRequest("title", "url"));
        assert game.getTitle() == "title2";
        assert game.getThumbnailURL() == "url";
    }
}