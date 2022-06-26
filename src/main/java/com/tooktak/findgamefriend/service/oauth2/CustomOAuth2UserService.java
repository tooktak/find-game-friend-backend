package com.tooktak.findgamefriend.service.oauth2;

import com.tooktak.findgamefriend.domain.AuthProvider;
import com.tooktak.findgamefriend.domain.Member;
import com.tooktak.findgamefriend.infrastructure.MemberRepository;
import com.tooktak.findgamefriend.service.oauth2.exception.OAuth2AuthenticationProcessingException;
import com.tooktak.findgamefriend.service.oauth2.user.OAuth2UserInfo;
import com.tooktak.findgamefriend.service.oauth2.user.OAuth2UserInfoFactory;
import com.tooktak.findgamefriend.service.oauth2.user.OAuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<Member> userOptional = memberRepository.findByEmail(oAuth2UserInfo.getEmail());
        Member member;
        if(userOptional.isPresent()) {
            member = userOptional.get();
            if(!member.getAuthProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                        member.getAuthProvider() + " account. Please use your " + member.getAuthProvider() +
                        " account to login.");
            }
            member = updateExistingUser(member, oAuth2UserInfo);
        } else {
            member = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }
        return OAuthUser.create(member, oAuth2User.getAttributes());
    }

    private Member registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        AuthProvider authProvider = AuthProvider.valueOf(
                oAuth2UserRequest.getClientRegistration().getRegistrationId()
        );

        Member member = new Member(
                oAuth2UserInfo.getId(),
                oAuth2UserInfo.getEmail(),
                oAuth2UserInfo.getName(),
                oAuth2UserInfo.getImageUrl(),
                authProvider);
        return memberRepository.save(member);
    }

    private Member updateExistingUser(Member existingUser, OAuth2UserInfo oAuth2UserInfo) {
        // TODO: 사용자 정보 업데이트
        return existingUser;
    }
}
