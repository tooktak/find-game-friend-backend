package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import com.tooktak.findgamefriend.service.dto.FindMatePost.ListByContentsResponse;
import com.tooktak.findgamefriend.service.dto.FindMatePost.ListByHashtagResponse;
import com.tooktak.findgamefriend.service.dto.FindMatePost.ListByTitleWithPageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

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
                "memberId3",
                "password3",
                "email3",
                "nickname3",
                "pictureURL3"
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

        List<FindMatePostDTO> findMatePostDTOList = findMatePostService.listByGame(game.getId());
        List<Long> ids = findMatePostDTOList.stream().map(d -> d.getId()).collect(Collectors.toList());

        assert ids.contains(findMatePost2.getId()) == true;
        assert ids.contains(findMatePost1.getId()) == true;
    }

    @Test
    public void testListByTitle() {
        Member member = new Member(
                "memberId1",
                "password1",
                "email1",
                "nickname1",
                "pictureURL1"
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

        ListByTitleWithPageResponse response = findMatePostService.listByTitleWithPage("title", Pageable.ofSize(10));
        List<Long> ids = response.getFindMatePosts()
                .stream()
                .map(f -> f.getId())
                .collect(Collectors.toList());

        assert ids.contains(findMatePost1.getId()) == true;
        assert ids.contains(findMatePost2.getId()) == true;
    }

    @Test
    public void testListByHashtag() {
        Member member = new Member(
                "member3211",
                "password",
                "email",
                "nickname1231",
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

        findMatePost1 = findMatePostRepository.save(findMatePost1);

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

        findMatePost2 = findMatePostRepository.save(findMatePost2);

        ListByHashtagResponse response = findMatePostService.listByHashtag("hashtag", Pageable.ofSize(10));
        List<Long> ids = response.getFindMatePostDTOs()
                .stream()
                .map(f -> f.getId())
                .collect(Collectors.toList());

        assert ids.contains(findMatePost1.getId()) == true;
        assert ids.contains(findMatePost2.getId()) == true;
    }
    @Test
    public void testListByContents(){
        Member member = new Member(
                "mem123",
                "mem123",
                "email@google.com",
                "hiHello",
                "picURL"
        );
        member = memberRepository.save(member);
        Game game = new Game("archeAge","archeURL");
        game = gameRepository.save(game);

        FindMatePost findMatePost = new FindMatePost(
                "title321",
                "contents321",
                "#hashtag231",
                "kakaoLink123",
                "discordLink321",
                LocalDateTime.now(),
                member,
                game
        );

        findMatePost = findMatePostRepository.save(findMatePost);

        ListByContentsResponse response = findMatePostService.listByContents(
                "conten",
                Pageable.ofSize(10)
        );
        List<Long> ids = response.getFindMatePosts()
                .stream()
                .map(f -> f.getId())
                .collect(Collectors.toList());

        assert ids.contains(findMatePost.getId()) == true;
    }
}