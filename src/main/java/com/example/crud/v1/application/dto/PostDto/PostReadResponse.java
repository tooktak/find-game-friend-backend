package com.example.crud.v1.application.dto.PostDto;

import com.example.crud.v1.domain.Post;

public class PostReadResponse {
    private Long id;
    private String title;
    private String contents;
    private String kakaoLink;
    private String discordLink;
    private String memberId;
    private String gameId;

    public PostReadResponse(Long id, String title, String contents, String kakaoLink, String discordLink, String memberId, String gameId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.memberId = memberId;
        this.gameId = gameId;
    }

    public static PostReadResponse fromEntity(Post p) {
        return new PostReadResponse(
                p.getId(),
                p.getTitle(),
                p.getContents(),
                p.getKakaoLink(),
                p.getDiscordLink(),
                p.getMemberId(),
                p.getGameId()
        );
    }

    public String getMemberId() {
        return memberId;
    }

    public String getGameId() {
        return gameId;
    }

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
}

