package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
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

    public ListByGameIdResponse listByGameId(Long id, Pageable pageable){
        Page<FindMatePost> byGameId = findMatePostRepository.getByGameId(id, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byGameId
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByGameIdResponse(findMatePostDTOs, byGameId.getTotalElements(), byGameId.getTotalPages(), byGameId.getPageable());
    }

    public ListByGameResponse listByGameTitle(String gameTitle, Pageable pageable){
       Page<FindMatePost> byGameTitle = findMatePostRepository.getByGameTitle(gameTitle, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byGameTitle
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByGameResponse(findMatePostDTOs, byGameTitle.getTotalElements(), byGameTitle.getTotalPages(), byGameTitle.getPageable());
    }

    public ListByHashtagResponse listByHashtag(String hashtag, Pageable pageable){
        Page<FindMatePost> byHashtag = findMatePostRepository.getByHashtagWithPage(hashtag, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byHashtag
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByHashtagResponse(findMatePostDTOs, byHashtag.getTotalElements(), byHashtag.getTotalPages(), byHashtag.getPageable());
    }

    public ListByContentsResponse listByContents(String contents, Pageable pageable){
        Page<FindMatePost> byContents = findMatePostRepository.getByContentsWithPage(contents, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byContents
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByContentsResponse(findMatePostDTOs, byContents.getTotalElements(), byContents.getTotalPages(), byContents.getPageable());
    }

    public ListByTitleWithPageResponse listByTitleWithPage(String title, Pageable pageable){
        Page<FindMatePost> byTitleWithPage = findMatePostRepository.getByTitleWithPage(title, pageable);
        List<FindMatePostDTO> findMatePostDTOs = byTitleWithPage
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return new ListByTitleWithPageResponse(findMatePostDTOs, byTitleWithPage.getTotalElements(), byTitleWithPage.getTotalPages(), byTitleWithPage.getPageable());
    }
}