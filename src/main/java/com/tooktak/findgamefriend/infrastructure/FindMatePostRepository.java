package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FindMatePostRepository extends JpaRepository<FindMatePost, Long> {
    FindMatePost getByTitle(String title);
    List<FindMatePost> getByGame(Game game);
    List<FindMatePost> getByTitle(FindMatePost findMatePost);
}
