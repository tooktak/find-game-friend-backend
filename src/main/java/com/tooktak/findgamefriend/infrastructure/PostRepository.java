package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> Page(Member member, Pageable pageable);
}
