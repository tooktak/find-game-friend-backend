package com.example.crud.v1.application.dto.GameDto;

public class GameCreateRequest {
    private Long id;
    private String gameName;
    private String thumbNail;

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

    public GameCreateRequest(Long id, String gameName, String thumbNail) {
        this.id = id;
        this.gameName = gameName;
        this.thumbNail = thumbNail;
    }
}
