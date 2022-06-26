package com.tooktak.findgamefriend.service.authentication;

import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
                );
        return SessionUser.create(member);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Member user = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return SessionUser.create(user);
    }
}