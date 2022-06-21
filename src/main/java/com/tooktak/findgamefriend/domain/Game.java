package com.tooktak.findgamefriend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String gameTitle;

    @Column(columnDefinition = "TEXT")
    private String thumbnailURL;

    public Game(String gameTitle, String thumbnailURL) {
        this.gameTitle = gameTitle;
        this.thumbnailURL = thumbnailURL;
    }

    public Game(){}

    public Long getId() {
        return id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
