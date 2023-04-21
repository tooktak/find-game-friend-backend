package com.example.crud.v1.infrastructure;

import com.example.crud.v1.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    Post getById(Long aLong);


    List<Post> findByTitle(String s);
    List<Post> findByGameId(String s);
    @Query("SELECT p FROM Post p WHERE p.gameId IN :gameIds")
    List<Post> findAllByGameId(List<String> gameIds);
    List<Post> findByTitleContaining(String s);
    List<Post> findByContentsContaining(String contents);
    List<Post> findByMemberId(String s);


}