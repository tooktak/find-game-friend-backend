package com.example.crud.v1.application.Service;

import com.example.crud.v1.application.dto.UserDto.UserCreateRequest;
import com.example.crud.v1.domain.Post;
import com.example.crud.v1.domain.User;
import com.example.crud.v1.infrastructure.PostRepository;
import com.example.crud.v1.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    public User register(UserCreateRequest userCreateRequest) {
        return this.userRepository.save(userCreateRequest.toEntity());
    }

    public Long delete(final Long id){
        List<Post> postList = postRepository.findByMemberId(String.valueOf(id));
        for(int i =0; i<postList.size(); i++){
            Post post= postList.get(i);
            postRepository.delete(post);
        }
        userRepository.deleteById(id);
        return id;
    }
}
