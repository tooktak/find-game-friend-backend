package com.example.crud.v1.application.dto.GameDto;

import com.example.crud.v1.domain.Game;


public class GameReadResponse {
    private Long id;
    private String title;
    private String thumbnailURL;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public GameReadResponse(Long id, String title, String thumbnailURL) {
        this.id = id;
        this.title = title;
        this.thumbnailURL = thumbnailURL;
    }

    public static GameReadResponse fromEntity(Game game){
        return new GameReadResponse(
                game.getId(),
                game.getTitle(),
                game.getThumbnailURL()
        );
    }
}