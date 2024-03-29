package com.example.crud.v1.presentation.http.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private String secretKey;
    private long validityInMilliseconds;

    public JwtTokenProvider(@Value("&{security.jwt.token.secret-key}")String secretKey,@Value("${security.jwt.token.expire-length}") long validityInMilliseconds){
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.validityInMilliseconds= validityInMilliseconds;
    }

    //토큰 생성
    public String createToken(Long id){
        Claims claims = Jwts.claims().setSubject(String.valueOf(id));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);   // 유효기간 계산(지금으로부터 + 유효시간)
        logger.info("now: {}", now);
        logger.info("validity: {}",validity);

        return Jwts.builder()
                .setClaims(claims)  //sub 설정
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)  //암호화 방식
                .compact();
    }

    //토큰에서 값 추출
    public Long getSubject(String token){
        return Long.valueOf(Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }

    //유효한 토큰인지 확인
    public boolean validateToken(String token){
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
        return !claims.getBody().getExpiration().before(new Date());
    }
}
