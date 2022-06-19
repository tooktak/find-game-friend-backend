package com.tooktak.findgamefriend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FindMatePost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String hashtag;

    @Column(columnDefinition = "TEXT")
    private String kakaoLink;

    @Column(columnDefinition = "TEXT")
    private String discordLink;

    @Column
    private LocalDateTime latestPullUpDateTime;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(targetEntity = Game.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public FindMatePost(
            String title,
            String contents,
            String hashtag,
            String kakaoLink,
            String discordLink,
            LocalDateTime latestPullUpDateTime,
            Member member,
            Game game
    ) {
        this.title = title;
        this.contents = contents;
        this.hashtag = hashtag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.latestPullUpDateTime = latestPullUpDateTime;
        this.member = member;
        this.game = game;
    }

    public FindMatePost() {}

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getLatestPullUpDateTime() {
        return latestPullUpDateTime;
    }

    public Member getMember() {
        return member;
    }

    public Game getGame() {
        return game;
    }
}