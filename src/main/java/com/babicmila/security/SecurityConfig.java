package com.babicmila.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.babicmila.security.filter.AuthenticationFilter;
import com.babicmila.security.filter.ExceptionHandlerFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                AuthenticationFilter authenticationFilter = new AuthenticationFilter();
                authenticationFilter.setFilterProcessesUrl("/authenticate");

                http
                                .csrf(crf -> crf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(new AntPathRequestMatcher(
                                                                SecurityConstants.REGISTER_PATH,
                                                                HttpMethod.POST.toString()))
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                                .addFilter(authenticationFilter)
                                .sessionManagement(sessionman -> sessionman
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                return http.build();
        }

}
