package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game getByGameTitle(String title);

    Page<Game> findAll(Pageable pageable);
}
