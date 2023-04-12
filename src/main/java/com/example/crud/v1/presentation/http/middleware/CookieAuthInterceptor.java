package com.example.crud.v1.presentation.http.middleware;

import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import com.example.crud.v1.presentation.http.util.TokenEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieAuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CookieAuthInterceptor.class);

    private JwtTokenProvider jwtTokenProvider;

    public CookieAuthInterceptor(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) {
        System.out.println(request.getRequestURL());
        logger.info(">>> interceptor.preHandle 호출");
        if(request.getCookies()==null){
            System.out.println("cookie is null");
            return false;
        }
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName());
            if (cookie.getName().equals("userInfo")) {
                String token = cookie.getValue();
                System.out.println(token);
                if (token.isEmpty()) {
                    throw new TokenEmptyException();// 이 클래스를 만들어서 맞는 에러를 집어 넣으면 됨
                }
                if (!jwtTokenProvider.validateToken(token)) {
                    throw new IllegalArgumentException("유효하지 않은 토큰");
                }
                Long id = jwtTokenProvider.getSubject(token);
                request.setAttribute("id", id);
                return true;
            }
        }
        return false;
    }
}