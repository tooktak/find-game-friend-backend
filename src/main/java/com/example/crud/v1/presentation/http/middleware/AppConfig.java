package com.example.crud.v1.presentation.http.middleware;

import com.example.crud.v1.presentation.http.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private CookieAuthInterceptor cookieAuthInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://aribomy.com", "https://find-game-friend-front-ivkv9rz0h-findgamefriends.vercel.app/")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/game/**")
                .addResourceLocations("src/main/resources/templates/image")
                .setCachePeriod(20);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cookieAuthInterceptor)
                .addPathPatterns("/game/create","/game/delete","/find-mate-post/create","/find-mate-post/update",
                        "/find-mate-post/delete/**","/find-mate-post/deleteAll/**",
                        "remove/") // 적용할 URL 패턴
                .excludePathPatterns("/oauth/google/callback**", "/logout"); // 제외할 URL 패턴
    }
}