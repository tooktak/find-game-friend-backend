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
    private String hashTag;

    @Column(columnDefinition = "TEXT")
    private String kakaoLink;

    @Column(columnDefinition = "TEXT")
    private String discordLink;

    @Column
    private LocalDateTime latestPullUpDateTime;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 20) // from Member nickname for search efficiency
    private String nickname;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    @Column  // from Game title for search efficiency
    private String gameTitle;

    public FindMatePost(
            String title,
            String contents,
            String hashTag,
            String kakaoLink,
            String discordLink,
            LocalDateTime latestPullUpDateTime,
            Member member,
            Game game
    ) {
        this.title = title;
        this.contents = contents;
        this.hashTag = hashTag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.latestPullUpDateTime = latestPullUpDateTime;
        this.member = member;
        this.nickname = member.getNickName();
        this.game = game;
        this.gameTitle = game.getTitle();
    }

    public FindMatePost() {
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
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
