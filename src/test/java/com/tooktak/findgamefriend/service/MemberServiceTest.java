package com.tooktak.findgamefriend.service;

import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.service.dto.member.MemberRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.config.location=classpath:application-test.yaml"})
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    void register() {
        // TODO: 리팩터
        Member member = memberService.register(new MemberRegisterRequest("qwe123", "qweqwe123", "qwe23@gmail.com", "ewq123", "tktktkriifooq12weq"));
        assert member.getPassword() == "qweqwe123";
        assert member.getEmail() == "qwe23@gmail.com";
        assert member.getName() == "ewq123";
        assert member.getPictureURL() == "tktktkriifooq12weq";
    }
}