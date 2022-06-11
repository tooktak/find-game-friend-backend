package com.tooktak.findgamefriend.infrastructure;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
class FindMatePostRepositoryTest {
    @Autowired
    private FindMatePostRepository findMatePostRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private GameRepository gameRepository;

    @Test
    public void TestFindMateNoCascadingWithMember() {
        Member member = new Member(
                "memberId",
                "password",
                "email",
                "nickname",
                "pictureURL"
        );

        member = memberRepository.save(member);

        Game game = new Game("title", "thumbnail");
        gameRepository.save(game);

        FindMatePost findMatePost = new FindMatePost(
                "title",
                "contents",
                "hashtag",
                "kakao-link",
                "discord-link",
                LocalDateTime.now(),
                member,
                game
        );

        findMatePost = findMatePostRepository.save(findMatePost);
        memberRepository.delete(member);

        assert findMatePostRepository.getReferenceById(findMatePost.getId()) != null;
    }

    @Test
    public void TestFindMateNoCascadingWithGame() {
        Member member = new Member(
                "memberId",
                "password",
                "email",
                "nickname",
                "pictureURL"
        );

        member = memberRepository.save(member);

        Game game = new Game("title", "thumbnail");
        gameRepository.save(game);

        FindMatePost findMatePost = new FindMatePost(
                "title",
                "contents",
                "hashtag",
                "kakao-link",
                "discord-link",
                LocalDateTime.now(),
                member,
                game
        );

        findMatePost = findMatePostRepository.save(findMatePost);
        gameRepository.delete(game);

        assert findMatePostRepository.getReferenceById(findMatePost.getId()) != null;
    }


}