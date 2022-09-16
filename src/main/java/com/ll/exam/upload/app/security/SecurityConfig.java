package com.ll.exam.upload.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/**").permitAll())
                .formLogin(formLogin -> formLogin
                        .loginPage("/member/login") // GET
                        .loginProcessingUrl("/member/login")) // POST
                .oauth2Login()
                .and()
                .logout(logout -> logout.logoutUrl("/member/logout"))
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
