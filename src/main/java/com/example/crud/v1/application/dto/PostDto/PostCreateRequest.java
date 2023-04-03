package com.example.crud.v1.application.dto.PostDto;

public class PostCreateRequest {
    private String title;
    private String contents;
    private String kakaoLink;
    private String discordLink;

    public PostCreateRequest() {
    }

    public PostCreateRequest(String title, String content, String kakaoLink, String discordLink) {
        this.title = title;
        this.contents = content;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
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
}
