package com.tooktak.findgamefriend.service.dto.FindMatePost;

public class FindMatePostRegisterRequest {
    private String title;
    private String contents;
    private String hashTag;
    private String kakaoLink;
    private String discordLink;

    public FindMatePostRegisterRequest(String title, String contents, String hashTag, String kakaoLink, String discordLink) {
        this.title = title;
        this.contents = contents;
        this.hashTag = hashTag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getHashTag() {
        return hashTag;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }
}
