package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FindMatePostRepository extends JpaRepository<FindMatePost, Long> {
    @Query("select f from FindMatePost as f where f.title like CONCAT('%',:title,'%')")
    List<FindMatePost> getByTitle(String title);
    List<FindMatePost> getByGame(Game game);
    List<FindMatePost> getByHashtag(String hashtag);
    List<FindMatePost> getByContents(String contents);
}