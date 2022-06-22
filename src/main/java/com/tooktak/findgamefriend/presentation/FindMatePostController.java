package com.tooktak.findgamefriend.presentation;

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

    @GetMapping("/find-mate-post/by-game-page")
    @ResponseStatus(code = HttpStatus.OK)

    public ListByGameResponse listByGame(@RequestParam("gameTitle") String gameTitle, Pageable pageable){
        return findMatePostService.listByGameTitle(gameTitle,pageable);

    @GetMapping("/find-mate-post/by-hashtag")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByHashtagResponse listByHashtag(@RequestParam("hashtag")String hashtag, Pageable pageable){
        return findMatePostService.listByHashtag(hashtag,pageable);
    }

    @GetMapping("/find-mate-post/by-title")
    @ResponseStatus(code = HttpStatus.OK)

    public ListByContentsResponse listByContents(@RequestParam("contents")String contents, Pageable pageable){
        return findMatePostService.listByContents(contents,pageable);
    }

    @GetMapping("/find-mate-post/by-title-page")
    @ResponseStatus(code = HttpStatus.OK)
    public ListByTitleWithPageResponse listByTitleWithPage (@RequestParam("title") String title, Pageable pageable){
        return findMatePostService.listByTitleWithPage(title,pageable);
    }
}