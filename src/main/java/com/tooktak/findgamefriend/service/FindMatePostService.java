package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostRegisterRequest;
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

    public FindMatePost save(FindMatePostRegisterRequest req) {
        FindMatePost findMatePost = new FindMatePost(req.getTitle(), req.getContents(),req.getHashtag(),req.getKakaoLink(),req.getDiscordLink());
        return findMatePostRepository.save(findMatePost);
    }
}
