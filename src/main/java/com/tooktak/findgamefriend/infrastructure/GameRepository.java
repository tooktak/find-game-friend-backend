package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game getBythumbnail(String thumbnail);
}
