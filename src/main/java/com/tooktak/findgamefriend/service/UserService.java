package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.User;
import com.tooktak.findgamefriend.domain.UserType;
import com.tooktak.findgamefriend.infrastructure.UserRepository;
import com.tooktak.findgamefriend.service.dto.user.UserRegisterRequest;
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

    public User register(UserRegisterRequest req) {
        User user = new User(req.getUserId(), req.getPassword(), req.getEmail(), req.getNickName(), req.getPictureURL(), UserType.NORMAL);
        return userRepository.save(user);
    }
}
