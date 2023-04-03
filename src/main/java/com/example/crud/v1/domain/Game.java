package com.example.crud.v1.domain;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 255)
    private String title;

    @Column(nullable = false)
    private String thumbnailURL;

    public Game(String title, String thumbnailURL) {
    }

    public Game() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public Game(Long id, String title, String thumbnailURL) {
        this.id = id;
        this.title = title;
        this.thumbnailURL = thumbnailURL;
    }




}
