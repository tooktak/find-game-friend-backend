package com.tooktak.findgamefriend.service.dto.FindMatePost;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class ListByGameResponse {
    private List<FindMatePostDTO> findMatePostDTOS;
    private Long totalElements;
    private Integer totalpages;
    private Pageable pageable;

    public ListByGameResponse(List<FindMatePostDTO> findMatePostDTOS, Long totalElements, Integer totalpages, Pageable pageable) {
        this.findMatePostDTOS = findMatePostDTOS;
        this.totalElements = totalElements;
        this.totalpages = totalpages;
        this.pageable = pageable;
    }

    public ListByGameResponse() {}

    public List<FindMatePostDTO> getFindMatePostDTOS() {
        return findMatePostDTOS;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalpages() {
        return totalpages;
    }

    public Pageable getPageable() {
        return pageable;
    }
}