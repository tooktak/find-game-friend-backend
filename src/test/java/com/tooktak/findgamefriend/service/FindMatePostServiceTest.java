package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest(properties = {"spring.config.location=classpath:application-test.yaml"})
class FindMatePostServiceTest {
    @Autowired
    private FindMatePostService findMatePostService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private FindMatePostRepository findMatePostRepository;

    @Test
    public void testListByGame() {
        Member member = new Member(
                "memberId",
                "password",
                "email",
                "nickname",
                "pictureURL"
        );
        member = memberRepository.save(member);
        Game game = new Game("mapleStory", "url");
        game = gameRepository.save(game);


        FindMatePost findMatePost1 = new FindMatePost(
                "title1",
                "contents1",
                "hashtag1",
                "kakao1",
                "discord1",
                LocalDateTime.now(),
                member,
                game
        );

        findMatePostRepository.save(findMatePost1);

        FindMatePost findMatePost2 = new FindMatePost(
                "title2",
                "contents2",
                "hashtag2",
                "kakao2",
                "discord2",
                LocalDateTime.now(),
                member,
                game
        );

        findMatePostRepository.save(findMatePost2);

        List<FindMatePostDTO> findMatePostDTOList = findMatePostService.ListByGame(game.getId());
        List<Long> findMatePostIdList = findMatePostDTOList.stream().map(d -> d.getId()).collect(Collectors.toList());
        List<FindMatePostDTO> findMatePostDTOList1 = findMatePostService.ListByTitle(findMatePost1.getTitle());
        List<String> findMatePostTitleList = findMatePostDTOList1.stream().map(f -> f.getTitle()).collect(Collectors.toList());

        assert findMatePostIdList.contains(findMatePost2.getId()) == true;
        assert findMatePostIdList.contains(findMatePost1.getId()) == true;
        assert findMatePostTitleList.contains(findMatePost1.getTitle()) == true;
        assert findMatePostTitleList.contains(findMatePost2.getTitle()) == true;
    }
}