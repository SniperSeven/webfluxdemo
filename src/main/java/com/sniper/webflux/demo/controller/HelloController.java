package com.sniper.webflux.demo.controller;

import com.sniper.webflux.demo.module.Hello;
import com.sniper.webflux.demo.repository.HelloRepository;
import com.sniper.webflux.demo.repository.HelloRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Chengyafeng
 * @date 2022/02/12 23:49
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloRepository repository;

    @Autowired
    private HelloRepository2 repository2;

    @RequestMapping("/hello")
    public Mono<Integer> hello(){
        return repository.findById(Mono.just("sniper")).map(Hello::getAge);
    }

    @RequestMapping("/hello2")
    public Mono<Integer> hello2(){
        return repository2.getOne("sniper").map(Hello::getAge);

    }
}
