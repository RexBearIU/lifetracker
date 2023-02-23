package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// @Order(SecurityProperties.BASIC_AUTH_ORDER)
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http)  throws Exception  {

        http.csrf().disable();

        http.authorizeHttpRequests()
                .anyRequest().authenticated();
        
        // http.formLogin();
        http.formLogin(form -> form
                .loginPage("/user/login")
                .permitAll()
                )
                .anonymous();
        
        http.httpBasic();

        return http.build();
    }

    // @Bean
    // public PasswordEncoder getPwdEncoder() {

    //     return new BCryptPasswordEncoder();
    // }

}