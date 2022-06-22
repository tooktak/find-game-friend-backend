package com.tooktak.findgamefriend.service.dto.FindMatePost;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class ListByGameResponse {
    private List<FindMatePostDTO> findMatePostDTOs;
    private Long totalElements;
    private Integer totalPages;
    private Pageable pageable;

    public ListByGameResponse(List<FindMatePostDTO> findMatePostDTOs, Long totalElements, Integer totalPages, Pageable pageable) {
        this.findMatePostDTOs = findMatePostDTOs;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageable = pageable;
    }

    public ListByGameResponse() {}

    public List<FindMatePostDTO> getFindMatePostDTOs() {
        return findMatePostDTOs;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Pageable getPageable() {
        return pageable;
    }
}