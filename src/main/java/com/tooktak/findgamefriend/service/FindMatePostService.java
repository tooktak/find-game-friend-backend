package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FindMatePostService {

    private final FindMatePostRepository findMatePostRepository;
    private final GameRepository gameRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public FindMatePostService(FindMatePostRepository findMatePostRepository, GameRepository gameRepository, MemberRepository memberRepository){
        this.findMatePostRepository = findMatePostRepository;
        this.gameRepository = gameRepository;
        this.memberRepository = memberRepository;
    }

    public FindMatePost save(FindMatePostRegisterRequest req) {
        return null;
    }

    public List<FindMatePostDTO> ListByGame(Long gameId){   //gameId => primaryKey
        Game game = gameRepository.getReferenceById(gameId);
        List<FindMatePost> findMatePosts = findMatePostRepository.getByGame(game);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }

    public List<FindMatePostDTO> ListByHashtag(String hashtag){
        List<FindMatePost> findMatePosts = findMatePostRepository.getByHashtag(hashtag);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }

    public List<FindMatePostDTO> ListByTitle(String title){
        /*Member member = new Member(
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

        FindMatePost findMatePost2 = new FindMatePost(
                "title2",
                "contents1",
                "hashtag1",
                "kakao1",
                "discord1",
                LocalDateTime.now(),
                member,
                game
        );

        findMatePostRepository.save(findMatePost1);
        findMatePostRepository.save(findMatePost2);*/

        List<FindMatePost> findMatePosts = findMatePostRepository.getByTitle(title);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }
}
