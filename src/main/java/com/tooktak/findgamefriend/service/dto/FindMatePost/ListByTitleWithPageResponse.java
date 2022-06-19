package com.tooktak.findgamefriend.service.dto.FindMatePost;

import org.springframework.data.domain.Pageable;
import java.util.List;

public class ListByTitleWithPageResponse {

    private List<FindMatePostDTO> findMatePosts;
    private Pageable pageable;
    private Long totalElements;
    private Integer totalPages;

    public ListByTitleWithPageResponse(List<FindMatePostDTO> findMatePosts, Long totalElements, Integer totalPages, Pageable pageable) {
        this.findMatePosts = findMatePosts;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageable = pageable;
    }


    public Pageable getPageable() {
        return pageable;
    }

    public List<FindMatePostDTO> getFindMatePosts() {
        return findMatePosts;
    }

    public ListByTitleWithPageResponse() {}

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}
