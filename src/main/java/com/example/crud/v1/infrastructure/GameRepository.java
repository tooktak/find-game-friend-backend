package com.example.crud.v1.infrastructure;

import com.example.crud.v1.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    @Override
    Game getById(Long aLong);
    List<Game> findByGameName(String gameName);
    Game getByGameName(String gameName);
}
