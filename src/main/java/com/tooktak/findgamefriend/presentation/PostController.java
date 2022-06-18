package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.service.PostService;
import com.tooktak.findgamefriend.service.dto.FindMatePost.FindMatePostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public List<FindMatePostDTO> find (Pageable pageable){
        return postService.findAll(pageable).;
    }
}
