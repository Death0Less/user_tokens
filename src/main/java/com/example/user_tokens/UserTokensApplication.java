package com.example.user_tokens;

import com.example.user_tokens.properties.LogicStatusProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(LogicStatusProperties.class)
public class UserTokensApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTokensApplication.class, args);
    }

}
