package com.example.crud.v1.infrastructure;

import com.example.crud.v1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitle(String s);
    List<Post> findByGameId(String s);
    List<Post> findByTitleContaining(String s);
    List<Post> findByContentsContaining(String contents);


}