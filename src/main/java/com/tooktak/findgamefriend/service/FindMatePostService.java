package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.FindMatePost;
import com.tooktak.findgamefriend.infrastructure.FindMatePostRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class FindMatePostService {

    private final FindMatePostRepository findMatePostRepository;

    @Autowired
    public FindMatePostService(FindMatePostRepository findMatePostRepository){
        this.findMatePostRepository = findMatePostRepository;
    }

    public FindMatePost save() {
        // TODO: 실제로 동작하도록 변경
        return null;
    }
}
