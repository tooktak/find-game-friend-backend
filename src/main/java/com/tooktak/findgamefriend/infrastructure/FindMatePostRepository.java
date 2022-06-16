package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FindMatePostRepository extends JpaRepository<FindMatePost, Long> {
    @Query("select f from FindMatePost as f where f.title like CONCAT('%',:title,'%')") //제목 포함단어 검색
    List<FindMatePost> getByTitle(String title);
    List<FindMatePost> getByGame(Game game);

    @Query("select f from FindMatePost as f where f.hashtag like CONCAT('%',:hashtag,'%')")
    List<FindMatePost> getByHashtag(String hashtag);

    @Query("select f from FindMatePost as f where f.contents like CONCAT('%',:contents,'%')")
    List<FindMatePost> getByContents(String contents);
}