package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FindMatePostService {

    private final FindMatePostRepository findMatePostRepository;

    @Autowired
    public FindMatePostService(FindMatePostRepository findMatePostRepository){
        this.findMatePostRepository = findMatePostRepository;
    }

    public FindMatePost save() {
        FindMatePost findMatePost = new FindMatePost("helloWorld","qweqwe123", "#3311w", "riifkkddfeqwee", "rtrtiiigfg1233qsd233123");
        findMatePostRepository.save(findMatePost);
        return findMatePostRepository.getByTitle("helloWorld");
    }
}
