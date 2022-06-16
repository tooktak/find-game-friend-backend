package com.tooktak.findgamefriend.service.dto.FindMatePost;

import java.util.List;

public class ListByContentsResponse {
    private List<FindMatePostDTO> findMatePosts;

    public ListByContentsResponse(List<FindMatePostDTO> findMatePosts) {
        this.findMatePosts = findMatePosts;
    }

    public ListByContentsResponse() {}

    public List<FindMatePostDTO> getFindMatePosts() {
        return findMatePosts;
    }
}
