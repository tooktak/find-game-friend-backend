package com.example.crud.v1.application.Service;

import com.example.crud.v1.application.Oauth.JwtTokenProvider;
import com.example.crud.v1.domain.GoogleUser;
import com.example.crud.v1.application.Oauth.OAuthToken;
import com.example.crud.v1.domain.User;
import com.example.crud.v1.infrastructure.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final OauthService oauthService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, OauthService oauthService, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.oauthService = oauthService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String oauthLogin(String code){
        ResponseEntity<String> accessTokenResponse = oauthService.createPostRequest(code);
        OAuthToken oAuthToken = oauthService.getAccessToken(accessTokenResponse);
        logger.info("Access Token: {}", oAuthToken.getAccessToken());

        ResponseEntity<String> userInfoResponse = oauthService.createGetRequest(oAuthToken);
        GoogleUser googleUser = oauthService.getUserInfo(userInfoResponse);
        logger.info("Google User Name: {}", googleUser.getName());

        if(!isJoinedUser(googleUser)){
            signUp(googleUser, oAuthToken);
        }
        User user = userRepository.findByeMail(googleUser.getEmail()).orElseThrow();
        return jwtTokenProvider.createToken(user.getId());
    }


    private boolean isJoinedUser(GoogleUser googleUser){
        Optional<User> users = userRepository.findByeMail(googleUser.getEmail());
        logger.info("Joined User: {}", users);
        return users.isPresent();
    }

    private void signUp (GoogleUser googleUser, OAuthToken oAuthToken){
        User user = googleUser.toUser(oAuthToken.getAccessToken());
        userRepository.save(user);
    }
}
