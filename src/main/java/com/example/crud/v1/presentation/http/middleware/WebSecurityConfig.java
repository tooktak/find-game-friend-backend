package com.example.crud.v1.presentation.http.middleware;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().configurationSource(request -> {
            var cors = new CorsConfiguration();

            cors.setAllowedOrigins(List.of("https://aribomy.com"));
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            cors.setAllowCredentials(true);
            return cors;
        });

        http.headers()
                .xssProtection()
                .xssProtectionEnabled(true) // XSS Protection 활성화
                .block(true); // XSS 공격 시 브라우저에서 차단

            http
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated();
    }
}