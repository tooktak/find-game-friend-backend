package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.infrastructure.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public void findAll(Pageable pageable) {
        postRepository.Page(createMember(), pageable)
                .map(PostRepositoryDTO::from);
    }
}
