package com.example.crud.v1.application.dto.GameDto;

public class GameCreateRequest {
    private Long id;
    private String title;
    private String thumbnailURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public GameCreateRequest(Long id, String gameName, String thumbNail) {
        this.id = id;
        this.title = gameName;
        this.thumbnailURL = thumbNail;
    }
}
