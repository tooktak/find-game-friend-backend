package com.example.crud.v1.application.dto.PostDto;

public class PostCreateRequest {
    private String title;
    private String contents;
    private String kakaoLink;
    private String discordLink;
    private String memberId;
    private String gameId;

    public PostCreateRequest(String title, String contents, String kakaoLink, String discordLink, String memberId, String gameId) {
        this.title = title;
        this.contents = contents;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.memberId = memberId;
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public void setKakaoLink(String kakaoLink) {
        this.kakaoLink = kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public void setDiscordLink(String discordLink) {
        this.discordLink = discordLink;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
