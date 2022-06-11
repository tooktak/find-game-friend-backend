package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.dto.member.MemberRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member register(MemberRegisterRequest req) {
        Member member = new Member(
                req.getMemberId(),
                req.getPassword(),
                req.getEmail(),
                req.getNickName(),
                req.getPictureURL()
        );
        return memberRepository.save(member);
    }
}
