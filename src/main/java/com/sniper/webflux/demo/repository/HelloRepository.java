package com.sniper.webflux.demo.repository;

import com.sniper.webflux.demo.module.Hello;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Chengyafeng
 * @date 2022/02/12 23:54
 **/
@Repository
public interface HelloRepository extends ReactiveCrudRepository<Hello, String> {

    @Override
    Mono<Hello> findById(Publisher<String> publisher);




}
