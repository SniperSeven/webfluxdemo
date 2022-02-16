package com.sniper.webflux.demo.service;

import com.sniper.webflux.demo.module.Hello;
import com.sniper.webflux.demo.module.User;
import com.sniper.webflux.demo.repository.HelloRepository;
import com.sniper.webflux.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * 用于测试事务
 *
 * @Author: Yafeng
 * @Version: 1.0
 * <p>
 * Copyright © 2022 Hundsun Technologies Inc. All Rights Reserved
 **/
@Service
public class TransactionService {


    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionalOperator transactionalOperator;

    //@Transactional(rollbackFor = Exception.class)
    public Mono<User> testRollBack() {
        Hello hello = new Hello();
        hello.setName("jack" + new Random().nextInt());
        hello.setAge(22);
        hello.setNew(true);
        System.out.println(">.............hello: " + hello);


        User user = new User();
        user.setUsername("jack");
        user.setPassword("123456");
        user.setRoleName("user");
        user.setNew(true);
        System.out.println(">..............user: " + user);

        return helloRepository.save(hello)
                .then(userRepository.save(user)).doOnError(a -> {

                    //可以在这里进行异常处理
                    System.out.println("===== cyf ==== service 当前线程: " + Thread.currentThread().getName());
                    System.out.println("========== cyf error =====: " + a.getMessage());

                    //这里是开启事务
                }).as(transactionalOperator::transactional)

                //这个主要不把异常抛到前端去, 注意不能放到as前面去, 否则事务会失效, 或者把这个逻辑放到controller里面去
                .onErrorResume(e -> Mono.just(new User()));
    }
}
