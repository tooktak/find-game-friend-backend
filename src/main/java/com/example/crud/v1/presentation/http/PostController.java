package com.example.crud.v1.presentation.http;

import com.example.crud.v1.application.Service.PostService;
import com.example.crud.v1.application.dto.PostDto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostDto.PostReadResponse;
import com.example.crud.v1.application.dto.PostDto.PostUpdateRequest;
import com.example.crud.v1.domain.Post;
import com.example.crud.v1.infrastructure.PostRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/find-mate-post")
@CrossOrigin(origins = "https://aribomy.com")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

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

    @DeleteMapping("/delete/{cardId}")
    public Long deletePost(@PathVariable(value = "cardId")Long cardId) {
        return postService.delete(cardId);
    }

    @DeleteMapping("/deleteAll")
    public Long allDeletePost(HttpServletRequest request){
        Long memberId = (Long) request.getAttribute("id");
            return postService.deleteAll(memberId);
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