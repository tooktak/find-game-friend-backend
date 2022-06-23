package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FindMatePostRepository extends JpaRepository<FindMatePost, Long> {

    Page<FindMatePost> getByGame(Game game, Pageable pageable);

    @Query("select f from FindMatePost as f where f.game.id = :id")
    Page<FindMatePost> getByGameId(@Param("id") Long id, Pageable pageable);

    @Query("select f from FindMatePost as f where f.game.title like CONCAT('%',:gameTitle,'%')")
    Page<FindMatePost> getByGameTitle(@Param("gameTitle") String gameTitle, Pageable pageable);

    @Query("select f from FindMatePost as f where f.hashtag like CONCAT('%',:hashtag,'%')")
    Page<FindMatePost> getByHashtagWithPage(@Param("hashtag") String hashtag,Pageable pageable);

    @Query("select f from FindMatePost as f where f.contents like CONCAT('%',:contents,'%')")
    Page<FindMatePost> getByContentsWithPage(@Param("contents") String contents,Pageable pageable);

    @Query("select f from FindMatePost as f where f.title like CONCAT('%',:title,'%')")
    Page<FindMatePost> getByTitleWithPage(@Param("title") String title, Pageable pageable);
}