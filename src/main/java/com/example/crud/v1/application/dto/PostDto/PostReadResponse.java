package com.example.crud.v1.application.dto.PostDto;

import com.example.crud.v1.domain.Post;

public class PostReadResponse {
    private Long id;
    private String title;
    private String contents;
    private String kakaoLink;
    private String discordLink;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public PostReadResponse() {
    }

    public PostReadResponse(Long id, String title, String content, String kakaoLink, String discordLink) {
        this.id = id;
        this.title = title;
        this.contents = content;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
    }

    public static PostReadResponse fromEntity(Post post) {
        return new PostReadResponse(
                post.getId(),
                post.getTitle(),
                post.getContents(),
                post.getKakaoLink(),
                post.getDiscordLink()
        );
    }
}
