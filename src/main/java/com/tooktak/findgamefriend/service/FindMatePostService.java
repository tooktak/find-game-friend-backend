package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.*;
import com.tooktak.findgamefriend.service.dto.game.GameCreateRequest;
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

    public List<FindMatePostDTO> ListByGame(Long gameId){
        Game game = gameRepository.getReferenceById(gameId);
        List<FindMatePost> findMatePosts = findMatePostRepository.getByGame(game);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }

    public ListByGameResponse listByGameResponse(String gameTitle, Pageable pageable){
        Page<Game> ByGameTitle = findMatePostRepository.getByGameTitle(gameTitle,pageable);
        List<FindMatePostDTO> findMatePostDTOS = ByGameTitle
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByGameResponse(findMatePostDTOS,ByGameTitle.getTotalElements(),ByGameTitle.getTotalPages(),pageable);
    }

    public ListByHashtagResponse ListByHashtag(String hashtag, Pageable pageable){
        Page<FindMatePost> byHashtag = findMatePostRepository.getByHashtagWithPage(hashtag, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byHashtag
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByHashtagResponse(findMatePostDTOs, byHashtag.getTotalElements(), byHashtag.getTotalPages(), byHashtag.getPageable());
    }

    public ListByContentsResponse ListByContents(String contents, Pageable pageable){
        Page<FindMatePost> byContents = findMatePostRepository.getByContentsWithPage(contents, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byContents
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByContentsResponse(findMatePostDTOs,byContents.getTotalElements(),byContents.getTotalPages(),pageable);
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