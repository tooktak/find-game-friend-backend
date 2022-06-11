package com.tooktak.findgamefriend.service.dto.FindMatePost;

import java.util.List;

public class ListByGameResponse {
    private List<FindMatePostDTO> findMatePosts;

    public ListByGameResponse(List<FindMatePostDTO> findMatePosts) {
        this.findMatePosts = findMatePosts;
    }
}