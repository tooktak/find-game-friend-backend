package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.Service.GameService;
import com.example.crud.v1.application.Service.PostService;
import com.example.crud.v1.application.dto.PostDto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostDto.PostReadResponse;
import com.example.crud.v1.application.dto.PostDto.PostUpdateRequest;
import com.example.crud.v1.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/find-mate-post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public List<PostReadResponse> AllPost(){
        return postService.getAll();
    }

    @PostMapping("/create")
    public Long createPost(@RequestBody PostCreateRequest r) {
        return postService.create(r);
    }

    @PutMapping("/update")
    public Long updatePost(@RequestBody PostUpdateRequest u) {
        return postService.update(u);
    }

    @DeleteMapping("/delete/{userId}")
    public Long deletePost(@PathVariable(value = "userId")Long userId) {
        return postService.delete(userId);
    }

    @DeleteMapping("/deleteAll/{userId}")
    public Long allDeletePost(@PathVariable(value = "userId")Long userId){
        return postService.deleteAll(userId);
    }

    @GetMapping("/by-title-page")
    public List<Post> findByTitle(@RequestParam(value = "q") String title) {
        return postService.findByTitle(title);
    }

    @GetMapping("/by-game-page")
    public List<Post> findByGameTitle(@RequestParam(value = "q")String gameTitle) {
        return postService.findByGameTitle(gameTitle);
    }

    @GetMapping("/by-contents-page")
    public List<Post> findByContents(@RequestParam(value = "q")String contents) {
        return postService.findByContents(contents);
    }

    @DeleteMapping("/deleteByTitle")
    public List<Long> deleteByTitlePost(@PathVariable(value = "title")String title) {
        return postService.deleteByTitle(title);
    }

    @GetMapping("/{id}")
    public PostReadResponse readPost(@PathVariable(value = "id") Long id) {
        PostReadResponse p = new PostReadResponse();
        System.out.println(p.getTitle());
        System.out.println(p.getContents());
        return postService.getPost(id);
    }
}