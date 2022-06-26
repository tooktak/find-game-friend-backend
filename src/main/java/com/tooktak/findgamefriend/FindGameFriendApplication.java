package com.tooktak.findgamefriend;

import com.tooktak.findgamefriend.adapter.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebSecurity
@EnableConfigurationProperties(AppProperties.class)
public class FindGameFriendApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC")); // use UTC
		SpringApplication.run(FindGameFriendApplication.class, args);
	}
}
