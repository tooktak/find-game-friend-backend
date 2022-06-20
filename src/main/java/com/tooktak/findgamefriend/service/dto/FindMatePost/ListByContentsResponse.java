package com.tooktak.findgamefriend.service.dto.FindMatePost;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class ListByContentsResponse {
    private List<FindMatePostDTO> findMatePosts;
    private Long totalElements;
    private Integer totalPages;
    private Pageable pageable;

    public ListByContentsResponse() {
    }

    public ListByContentsResponse(List<FindMatePostDTO> findMatePosts, Long totalElements, Integer totalPages, Pageable pageable) {
        this.findMatePosts = findMatePosts;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageable = pageable;
    }

    public List<FindMatePostDTO> getFindMatePosts() {
        return findMatePosts;
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
