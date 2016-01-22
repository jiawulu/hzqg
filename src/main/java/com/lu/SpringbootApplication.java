package com.lu;

import com.lu.config.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringbootApplication {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public MappedInterceptor myMappedInterceptor() {
        return new MappedInterceptor(new String[]{"/**"}, loginInterceptor());
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
