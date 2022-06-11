package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.config.location=classpath:application-test.yaml"})
class FindMatePostServiceTest {
    @Autowired private FindMatePostService findMatePostService;

    @Test
    void save() {
        FindMatePost findMatePost = findMatePostService.save(new FindMatePostRegisterRequest("hello","hello world!!@", "#hiworld","rjrjrjdfgii5123mmg","cgiierui3545199e54rej"));
        assert findMatePost.getTitle() == "hello";
        assert findMatePost.getContents() == "hello world!!@";
        assert findMatePost.getHashtag() == "#hiworld";
        assert findMatePost.getKakaoLink() == "rjrjrjdfgii5123mmg";
        assert findMatePost.getDiscordLink() == "cgiierui3545199e54rej";
    }
}