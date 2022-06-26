package com.tooktak.findgamefriend.service.oauth2.user;

import com.tooktak.findgamefriend.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class OAuthUser implements OAuth2User {
    private Long id;
    private String email;
    private String password;
    private Map<String, Object> attributes;

    public OAuthUser(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static OAuthUser create(Member member) {
        OAuthUser OAuthUser = new OAuthUser(member.getId(), member.getEmail(), member.getPassword());
        return OAuthUser;
    }

    public static OAuthUser create(Member member, Map<String, Object> attributes) {
        OAuthUser OAuthUser = create(member);
        OAuthUser.setAttributes(attributes);
        return OAuthUser;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return this.email;
    }

    public String getPassword() {
        return password;
    }

    private void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}

