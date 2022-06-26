package com.tooktak.findgamefriend.service.authentication;

import com.tooktak.findgamefriend.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class SessionUser implements UserDetails {
    private Long id;
    private String email;
    private String password;

    public SessionUser(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static SessionUser create(Member member) {
        SessionUser SessionUser = new SessionUser(member.getId(), member.getEmail(), member.getPassword());
        return SessionUser;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Unused
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
