package com.sniper.webflux.demo.repository;

import com.sniper.webflux.demo.module.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Chengyafeng
 * @date 2022/02/13 00:07
 **/

@Component
public class HelloRepository2 {

    @Autowired
    private DatabaseClient databaseClient;

    public Mono<Hello> getOne(String name) {

        return databaseClient.execute("select * from hello where name = :name")
                .bind("name", name)
                .as(Hello.class)
                .fetch()
                .one();
    }
}
