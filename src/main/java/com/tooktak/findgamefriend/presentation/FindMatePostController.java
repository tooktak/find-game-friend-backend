package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.infrastructure.GameRepository;
import com.tooktak.findgamefriend.service.FindMatePostService;
import com.tooktak.findgamefriend.service.GameService;
import com.tooktak.findgamefriend.service.dto.FindMatePost.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/find-mate-post/by-game-page")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByGameResponse ListByGame(@RequestParam("title") String title, Pageable pageable){
        return findMatePostService.listByGameResponse(title,pageable);
    }

    @GetMapping("/find-mate-post/by-hashtag-page")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByHashtagResponse listByHashtag(@RequestParam("hashtag")String hashtag, Pageable pageable){
        return findMatePostService.ListByHashtag(hashtag,pageable);
    }

    @GetMapping("/find-mate-post/by-contents-page")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByContentsResponse listByContents(@RequestParam("contents")String contents, Pageable pageable){
        return findMatePostService.ListByContents(contents,pageable);
    }

    @GetMapping("/find-mate-post/by-title-page")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByTitleWithPageResponse listByTitleWithPage (@RequestParam("title") String title, Pageable pageable){
        return findMatePostService.ListByTitleWithPage(title,pageable);
    }
}