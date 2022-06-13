package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.service.FindMatePostService;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostRegisterRequest;
import com.tooktak.findgamefriend.service.dto.FindMatePost.ListByGameResponse;
import com.tooktak.findgamefriend.service.dto.FindMatePost.ListByTitleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class FindMatePostController {
    private final FindMatePostService findMatePostService;
    private final GameRepository gameRepository;

    public FindMatePostController(FindMatePostService findMatePostService, GameRepository gameRepository) {
        this.findMatePostService = findMatePostService;
        this.gameRepository = gameRepository;
    }

    @PostMapping("/find-mate-post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void FindMatePostSave(@RequestBody FindMatePostRegisterRequest findMatePostRegisterRequest){
        findMatePostService.save(findMatePostRegisterRequest);
    }

    @GetMapping("/by-game")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByGameResponse ListByGame(@RequestParam Long gameId){
        List<FindMatePostDTO> findMatePostDTOList = findMatePostService.ListByGame(gameId);
        ListByGameResponse listByGameResponse = new ListByGameResponse(findMatePostDTOList);
        return listByGameResponse;
    }

    @GetMapping("/by-title")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByTitleResponse listByTitle(@RequestParam String title){
        List<FindMatePostDTO> findMatePostDTOList = findMatePostService.ListByTitle(title);
        ListByTitleResponse listByTitleResponse = new ListByTitleResponse(findMatePostDTOList);
        return listByTitleResponse;
    }

}