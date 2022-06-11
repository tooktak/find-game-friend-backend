package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FindMatePostRepository extends JpaRepository<FindMatePost, Long> {
    FindMatePost getByTitle(String title);
}
