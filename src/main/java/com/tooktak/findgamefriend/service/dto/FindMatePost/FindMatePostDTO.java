package com.tooktak.findgamefriend.service.dto.FindMatePost;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.domain.Game;

public class FindMatePostDTO {
    private Long id;
    private String title;
    private String contents;
    private String hashtag;
    private String kakaoLink;
    private String discordLink;
    private String nickname;
    private String gameTitle;

    public FindMatePostDTO(FindMatePost findMatePost) {
        this.id = findMatePost.getId();
        this.title = findMatePost.getTitle();
        this.contents = findMatePost.getContents();
        this.hashtag = findMatePost.getHashtag();
        this.kakaoLink = findMatePost.getKakaoLink();
        this.discordLink = findMatePost.getDiscordLink();
        this.nickname = findMatePost.getMember().getNickName();
        this.gameTitle = findMatePost.getGame().getTitle();
    }

    public FindMatePostDTO() {}

    public FindMatePostDTO(Game f) {}

    public Long getId() {
        return id;
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

    public String getNickname() {
        return nickname;
    }

    public String getGameTitle() {
        return gameTitle;
    }
}
