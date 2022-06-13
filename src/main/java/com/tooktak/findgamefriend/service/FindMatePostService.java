package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FindMatePostService {

    private final FindMatePostRepository findMatePostRepository;
    private final GameRepository gameRepository;

    @Autowired
    public FindMatePostService(FindMatePostRepository findMatePostRepository, GameRepository gameRepository){
        this.findMatePostRepository = findMatePostRepository;
        this.gameRepository = gameRepository;
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

    public List<FindMatePostDTO> ListByTitle(String title){
        List<FindMatePost> findMatePost = findMatePostRepository.getByTitle(title);
        List<FindMatePost> findMatePosts = findMatePostRepository.getByTitle(title);
        List<FindMatePostDTO> findMatePostDTOs = findMatePosts
                .stream()
                .map(f -> new FindMatePostDTO(f))
                .collect(Collectors.toList());
        return findMatePostDTOs;
    }
}
