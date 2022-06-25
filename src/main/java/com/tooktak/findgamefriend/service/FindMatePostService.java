package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.*;
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

    public FindMatePostResponse listByGameId(Long gameId, Pageable pageable){
        Page<FindMatePost> byGameId = findMatePostRepository.getByGame(gameRepository.getReferenceById(gameId), pageable);
        List<FindMatePostDTO> findMatePostDTOs = byGameId
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new FindMatePostResponse(findMatePostDTOs, byGameId.getTotalElements(), byGameId.getTotalPages(), byGameId.getPageable());
    }

    public FindMatePostResponse listByGameTitle(String gameTitle, Pageable pageable){
       Page<FindMatePost> byGameTitle = findMatePostRepository.getByGame(gameRepository.getByGameTitle(gameTitle),pageable);
        List<FindMatePostDTO> findMatePostDTOs = byGameTitle
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new FindMatePostResponse(findMatePostDTOs, byGameTitle.getTotalElements(), byGameTitle.getTotalPages(), byGameTitle.getPageable());
    }

    public FindMatePostResponse listByHashtag(String hashtag, Pageable pageable){
        Page<FindMatePost> byHashtag = findMatePostRepository.getByHashtagWithPage(hashtag, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byHashtag
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new FindMatePostResponse(findMatePostDTOs, byHashtag.getTotalElements(), byHashtag.getTotalPages(), byHashtag.getPageable());
    }

    public FindMatePostResponse listByContents(String contents, Pageable pageable){
        Page<FindMatePost> byContents = findMatePostRepository.getByContentsWithPage(contents, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byContents
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new FindMatePostResponse(findMatePostDTOs, byContents.getTotalElements(), byContents.getTotalPages(), byContents.getPageable());
    }

    public FindMatePostResponse listByTitleWithPage(String title, Pageable pageable){
        Page<FindMatePost> byTitleWithPage = findMatePostRepository.getByTitleWithPage(title, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byTitleWithPage
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new FindMatePostResponse(findMatePostDTOs, byTitleWithPage.getTotalElements(), byTitleWithPage.getTotalPages(), byTitleWithPage.getPageable());
    }
}