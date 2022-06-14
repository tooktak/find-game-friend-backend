package com.tooktak.findgamefriend.service.dto.FindMatePost;

import java.util.List;

public class ListByHashtagResponse {
    private List<FindMatePostDTO> findMatePostDTOS;

    public ListByHashtagResponse(List<FindMatePostDTO> findMatePostDTOS) {
        this.findMatePostDTOS = findMatePostDTOS;
    }
    public ListByHashtagResponse(){}

    public List<FindMatePostDTO> getFindMatePostDTOS(){
        return findMatePostDTOS;
    }
}
