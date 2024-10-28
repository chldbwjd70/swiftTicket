package com.example.application.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class SecurityFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    public void configure(HttpSecurity http)  {
//        JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(jwtManager, pluginManager);
//        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
