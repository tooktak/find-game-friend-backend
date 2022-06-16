package com.tooktak.findgamefriend.service.dto.FindMatePost;

import java.util.List;

public class ListByGameResponse {
    private List<FindMatePostDTO> findMatePostDTOS;

    public ListByGameResponse(List<FindMatePostDTO> findMatePostDTOS) {
        this.findMatePostDTOS = findMatePostDTOS;
    }

    public ListByGameResponse(){}

    public List<FindMatePostDTO> getFindMatePostDTOS(){
        return findMatePostDTOS;
    }
}