package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.Service.PostService;
import com.example.crud.v1.application.dto.PostDto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostDto.PostReadResponse;
import com.example.crud.v1.application.dto.PostDto.PostUpdateRequest;
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

    @PostMapping("/post/create")
    public Long createPost(@RequestBody PostCreateRequest r) {
        return postService.create(r);
    }

    @PutMapping("/post/update")
    public Long updatePost(@RequestBody PostUpdateRequest u) {
        return postService.update(u);
    }

    @DeleteMapping("/post/delete")
    public Long deletePost(@PathVariable(value = "id")Long id) {
        return postService.delete(id);
    }

    @GetMapping("/post/findByTitle")
    public List findByTitle(@PathVariable(value = "title")String title) {
        return postService.findByTitle(title);
    }

    @DeleteMapping("/post/deleteByTitle")
    public List<Long> deleteByTitlePost(@PathVariable(value = "title")String title) {
        return postService.deleteByTitle(title);
    }


    @GetMapping("/post/{id}")
    public PostReadResponse readPost(@PathVariable(value = "id") Long id) {
        PostReadResponse p = new PostReadResponse();
        System.out.println(p.getTitle());
        System.out.println(p.getContents());
        return postService.getPost(id);
    }
}