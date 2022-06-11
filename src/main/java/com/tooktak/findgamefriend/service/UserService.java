package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.User;
import com.tooktak.findgamefriend.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save() {
        User user = new User("dasdsdas", "asdasdsadasdk", "emial@emial", "nickname", "url");
        userRepository.save(user);
        return userRepository.getByUserId("djh20");
    }
}
