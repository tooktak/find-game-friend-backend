package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostRegisterRequest;
import com.tooktak.findgamefriend.service.dto.FindMatePost.ListByTitleWithPageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<FindMatePostDTO> ListByContents(String contents){
        List<FindMatePost> findMatePosts = findMatePostRepository.getByContents(contents);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }

    public List<FindMatePostDTO> ListByTitle(String title){
        List<FindMatePost> findMatePosts = findMatePostRepository.getByTitle(title);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }

    public ListByTitleWithPageResponse ListByTitleWithPage(String title, Pageable pageable){
        Page<FindMatePost> byTitleWithPage = findMatePostRepository.getByTitleWithPage(title,pageable);
        List<FindMatePostDTO> findMatePostDTOs = byTitleWithPage
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByTitleWithPageResponse(findMatePostDTOs, byTitleWithPage.getTotalElements(), byTitleWithPage.getTotalPages(), byTitleWithPage.getPageable());
    }
}