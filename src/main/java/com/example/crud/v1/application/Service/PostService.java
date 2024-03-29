package com.example.crud.v1.application.Service;

import com.example.crud.v1.application.dto.PostDto.PostCreateRequest;
import com.example.crud.v1.application.dto.PostDto.PostReadResponse;
import com.example.crud.v1.application.dto.PostDto.PostUpdateRequest;
import com.example.crud.v1.domain.Game;
import com.example.crud.v1.domain.Post;
import com.example.crud.v1.infrastructure.GameRepository;
import com.example.crud.v1.infrastructure.PostRepository;
import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private HttpServletRequest request;

    public List<PostReadResponse> getAll(){
        return postRepository.findAll().stream().map(p-> PostReadResponse.fromEntity(p)).collect(Collectors.toList());
    }

    public Long create(final PostCreateRequest r) {
        Post p = new Post(r.getTitle(), r.getContents(),r.getKakaoLink(),r.getDiscordLink(),r.getMemberId(),r.getGameId());
        return postRepository.save(p).getId();
    }

    public Long update(final PostUpdateRequest u) {
        Post p = postRepository.getById(u.getId());
        p.setTitle(u.getTitle());
        p.setContents(u.getContents());
        p.setKakaoLink(u.getKakaoLink());
        p.setDiscordLink(u.getDiscordLink());
        p = postRepository.save(p);
        return p.getId();
    }

    public Long delete(final Long cardId) {
        Long memberId = (Long) request.getAttribute("id");
        System.out.println("123");
        Post p = postRepository.getById(cardId);
        if(p.getMemberId().equals(String.valueOf(memberId)) == true){
            postRepository.delete(p);
            return p.getId();
        }
        else {
            return null;
        }
    }

    public Long deleteAll(final Long userId) {
        // 검색한 것에 대한 넘버값을 알아낸 후 삭제   리스트 순회해서 포스트 값 딜리트
        List<Post> postList = postRepository.findByMemberId(String.valueOf(userId));
        List<Long> deletedIds = new LinkedList<>();

        // i 0부터 10까지 순회
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            deletedIds.add(post.getId());
            postRepository.delete(post);
        }
        // 리턴하고싶은것이 삭제된 아이디의 리스트 번호
        return userId;
    }

    public List<Post> findByTitle(final String title) {
        // 타이틀을 검색해 그리고 그것을 리스트화 하고 리턴
        List<Post> postTitle = postRepository.findByTitleContaining(title);
        return postTitle;
    }

    public List<Post> findByGameTitle(final String gameTitle) {
        List<Game> searchGame = gameRepository.findByTitleContaining(gameTitle);
        List<String> getGameIds = new ArrayList<>();
        for(int i =0; i< searchGame.size(); i++){
            Game game = searchGame.get(i);
            getGameIds.add(String.valueOf(game.getId()));
        }
        List<Post> postGameTitle = postRepository.findAllByGameId(getGameIds);
        return postGameTitle;
    }

    public List<Post> findByContents(final String Contents) {
        List<Post> postContents = postRepository.findByContentsContaining(Contents);
        return postContents;
    }

    public List<Long> deleteByTitle(final String title) {
        // 검색한 것에 대한 넘버값을 알아낸 후 삭제   리스트 순회해서 포스트 값 딜리트
        List<Post> postList = postRepository.findByTitle(title);
        List<Long> deletedIds = new LinkedList<>();

        // i 0부터 10까지 순회
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            deletedIds.add(post.getId());
            postRepository.delete(post);
        }
        // 리턴하고싶은것이 삭제된 아이디의 리스트 번호
        return deletedIds;
    }

    public PostReadResponse getPost(final Long id) {
        return PostReadResponse.fromEntity(postRepository.getById(id));
    }
}
