package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindMatePostService {
    private final FindMatePostRepository findMatePostRepository;

    public FindMatePost save() {
        FindMatePost findMatePost = new FindMatePost("rerw", "qweqwe123", "#3311w", "riifkkddfeqwee", "rtrtiiigfg1233qsd233123");
        findMatePostRepository.save(findMatePost);
        return findMatePostRepository.getByPostId("rerw");
    }
}
