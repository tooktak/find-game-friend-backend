package com.tooktak.findgamefriend.service.dto.FindMatePost;

public class FindMatePostRegisterRequest {
    private String title;
    private String contents;
    private String hashtag;
    private String kakaoLink;
    private String discordLink;

    public FindMatePostRegisterRequest(String title, String contents, String hashtag, String kakaoLink, String discordLink) {
        this.title = title;
        this.contents = contents;
        this.hashtag = hashtag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }
}
