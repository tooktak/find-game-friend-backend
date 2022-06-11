package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUserId(String id);
}
