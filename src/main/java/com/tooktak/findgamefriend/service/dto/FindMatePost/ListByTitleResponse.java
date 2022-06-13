package com.tooktak.findgamefriend.service.dto.FindMatePost;

import java.util.List;

public class ListByTitleResponse {
    private List<FindMatePostDTO> findMatePosts;

    public ListByTitleResponse(List<FindMatePostDTO> findMatePosts){
        this.findMatePosts = findMatePosts;
    }

    public ListByTitleResponse() {
    }

    public List<FindMatePostDTO> getFindMatePosts() {
        return findMatePosts;
    }
}
