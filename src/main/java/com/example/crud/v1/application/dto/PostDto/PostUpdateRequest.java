package com.example.crud.v1.application.dto.PostDto;

public class PostUpdateRequest {
    private Long id;
    private String title;
    private String contents;
    private String kakaoLink;
    private String discordLink;
    private String gameId;

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

    public String getGameId() {
        return gameId;
    }

    public PostUpdateRequest(Long id, String title, String contents, String kakaoLink, String discordLink, String gameId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.gameId = gameId;
    }

    public PostUpdateRequest() {
    }


}
