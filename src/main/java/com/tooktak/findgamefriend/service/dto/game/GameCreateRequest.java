package com.tooktak.findgamefriend.service.dto.game;

public class GameCreateRequest {
    private String title;
    private String thumbnailURL;

    public GameCreateRequest(String title, String thumbnailURL) {
        this.title = title;
        this.thumbnailURL = thumbnailURL;
    }

    public GameCreateRequest() {}

    public String getTitle() {
        return title;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
