package com.example.crud.v1.infrastructure;


import com.example.crud.v1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    User getById(Long aLong);

    List<User> findById(String id);

    Optional<User> findByeMail(String s);

    User save(User user);
}
