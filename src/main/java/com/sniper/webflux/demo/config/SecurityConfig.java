package com.sniper.webflux.demo.config;

import com.sniper.webflux.demo.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Flux;

import java.util.StringJoiner;

/**
 * @author Chengyafeng
 * @date 2022/02/13 14:07
 **/
@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    private static final String[] noNeedAuthPattern = {"/", "/login", "/logout"};

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http.authorizeExchange().pathMatchers(noNeedAuthPattern).permitAll();
        http.authorizeExchange().anyExchange().authenticated();

        http.httpBasic().and()
                .csrf().disable();
        return http.build();
    }

}