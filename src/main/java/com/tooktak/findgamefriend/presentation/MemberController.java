package com.tooktak.findgamefriend.presentation;

import com.tooktak.findgamefriend.service.MemberService;
import com.tooktak.findgamefriend.service.dto.member.MemberRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/Member")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void MemberRegister(@RequestBody MemberRegisterRequest memberRegisterRequest){
        memberService.register(memberRegisterRequest);
    }
}