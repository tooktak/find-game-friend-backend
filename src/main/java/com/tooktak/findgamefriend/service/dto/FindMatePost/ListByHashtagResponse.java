package com.tooktak.findgamefriend.service.dto.FindMatePost;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class ListByHashtagResponse {
    private List<FindMatePostDTO> findMatePostDTOs;
    private Pageable pageable;
    private Long totalElements;
    private Integer totalPages;

    public ListByHashtagResponse(List<FindMatePostDTO> findMatePostDTOS, Long totalElements, Integer totalPages, Pageable pageable) {
        this.findMatePostDTOs = findMatePostDTOS;
        this.pageable = pageable;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public ListByHashtagResponse() {
    }

    public List<FindMatePostDTO> getFindMatePostDTOs() {
        return findMatePostDTOs;
    }
}
