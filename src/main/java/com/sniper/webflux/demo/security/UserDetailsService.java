package com.sniper.webflux.demo.security;

import com.sniper.webflux.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chengyafeng
 * @date 2022/02/13 14:15
 **/
@Service
public class UserDetailsService implements ReactiveUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        Mono<com.sniper.webflux.demo.module.User> byId = userRepository.findById(username);
        return byId.map(user -> {

             String[] roles = user.getRoleName().split(",");
             List<SimpleGrantedAuthority> authorities = new ArrayList<>();
             for (String role : roles) {
                 authorities.add(new SimpleGrantedAuthority(role));
             }
             return User.withUsername(user.getUsername()).password(user.getPassword()).authorities(authorities).build();
         });

    }
}
