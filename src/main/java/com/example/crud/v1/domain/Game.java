package com.example.crud.v1.domain;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 255)
    private String gameName;
    @Column(nullable = false)
    private String thumbNail;

    public Game(String gameName, String thumbNail) {

    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    public Game(Long id, String gameName, String thumbNail) {
        this.id = id;
        this.gameName = gameName;
        this.thumbNail = thumbNail;
    }
}
