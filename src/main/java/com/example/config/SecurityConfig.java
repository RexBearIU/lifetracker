package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {

        http.csrf(withDefaults());

        http.authorizeHttpRequests()
                .requestMatchers("/css/**", "/js/**", "/image/**", "/user/signup").permitAll()
                .anyRequest().authenticated();

        http.formLogin(form -> form
                .loginPage("/user/login")
                .successForwardUrl("/user/get")
                .permitAll())
                .logout((logout) -> logout.deleteCookies("remove")
                        .permitAll())
                .anonymous(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder getPwdEncoder() {

        return new BCryptPasswordEncoder();
    }

}