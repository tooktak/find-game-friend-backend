package com.example.crud.v1.presentation.http.middleware;

import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import com.example.crud.v1.presentation.http.util.TokenEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BearerAuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(BearerAuthInterceptor.class);

    private AuthorizationExtractor authorizationExtractor;
    private JwtTokenProvider jwtTokenProvider;

    public BearerAuthInterceptor(AuthorizationExtractor authorizationExtractor, JwtTokenProvider jwtTokenProvider) {
        this.authorizationExtractor = authorizationExtractor;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler){
        logger.info(">>> interceptor.preHandle 호출");
        String token = authorizationExtractor.extract(request, "Bearer");
        System.out.println(token);
        if(token.isEmpty()){
            throw new TokenEmptyException();// 이 클래스를 만들어서 맞는 에러를 집어 넣으면 됨
        }
        if(!jwtTokenProvider.validateToken(token)){
            throw new IllegalArgumentException("유효하지 않은 토큰");
        }
        Long id = jwtTokenProvider.getSubject(token);
        request.setAttribute("id",id);
        return true;
    }
}