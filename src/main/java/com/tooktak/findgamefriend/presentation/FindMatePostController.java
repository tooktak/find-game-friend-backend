package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.domain.Game;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.service.FindMatePostService;
import com.tooktak.findgamefriend.service.dto.FindMatePost.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        // TODO: 회원 작업 후 revisit
        return;
    }

    @GetMapping("/find-mate-post/by-id-page")
    @ResponseStatus(code = HttpStatus.OK)
    public FindMatePostResponse listByGameId(@RequestParam("id") Long id, Pageable pageable){
        return findMatePostService.listByGameId(id, pageable);
    }


    @GetMapping("/find-mate-post/by-game-page")
    @ResponseStatus(code = HttpStatus.OK)
    public FindMatePostResponse listByGameTitle(@RequestParam("title") String title, Pageable pageable) {
        return findMatePostService.listByGameTitle(title, pageable);
    }

    @GetMapping("/find-mate-post/by-hashtag-page")
    @ResponseStatus(code = HttpStatus.OK)
    public FindMatePostResponse listByHashtag(@RequestParam("hashtag") String hashtag, Pageable pageable){
        return findMatePostService.listByHashtag(hashtag, pageable);
    }

    @GetMapping("/find-mate-post/by-contents-page")
    @ResponseStatus(code = HttpStatus.OK)
    public FindMatePostResponse listByContents(@RequestParam("contents") String contents, Pageable pageable){
        return findMatePostService.listByContents(contents, pageable);
    }

    @GetMapping("/find-mate-post/by-title-page")
    @ResponseStatus(code = HttpStatus.OK)
    public FindMatePostResponse listByTitleWithPage(@RequestParam("title") String title, Pageable pageable){
        return findMatePostService.listByTitleWithPage(title, pageable);
    }
}