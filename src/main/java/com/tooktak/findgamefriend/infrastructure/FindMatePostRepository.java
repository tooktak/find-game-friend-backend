package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FindMatePostRepository extends JpaRepository<FindMatePost, Long> {
    Page<FindMatePost> getByGame(Game game, Pageable pageable);

    //get = select , from ? = 반환형(Return Type), = :? = 파라미터
    // jpql: select f from FindMatePost as f where f.hashtag like "%:hashtag%"
    // sql: select * from find_mate_post where hashtag like '%hashtag%'
    @Query("select f from FindMatePost as f where f.hashtag like CONCAT('%',:hashtag,'%')")
    Page<FindMatePost> getByHashtagWithPage(@Param("hashtag") String hashtag, Pageable pageable);

    // jpql : select f from FindMatePost as f where f.contents like "%:contents%"
    // sql : select * from find_mate_pst where contents like '%contents%'
    @Query("select f from FindMatePost as f where f.contents like CONCAT('%',:contents,'%')")
    Page<FindMatePost> getByContentsWithPage(@Param("contents") String contents, Pageable pageable);


    // jpql: select f from FindMatePost as f where f.title like "%:title%"
    // sql: select * from find_mate_post where title like '%title%'
    @Query("select f from FindMatePost as f where f.title like CONCAT('%',:title,'%')")
    Page<FindMatePost> getByTitleWithPage(@Param("title") String title, Pageable pageable);
}