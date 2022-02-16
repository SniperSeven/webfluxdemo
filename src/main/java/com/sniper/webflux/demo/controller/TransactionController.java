package com.sniper.webflux.demo.controller;

import com.sniper.webflux.demo.module.User;
import com.sniper.webflux.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @ProductName: Hundsun HEP
 * @Author: chengyf36747
 * @CreateDate: 2022-02-16 10:49
 * @Version: 1.0
 * <p>
 * Copyright © 2022 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/testTrx")
    public Mono<User> testTransaction() {
        // return 回去的Mono会自动被触发 subscribe, 否则并不会执行, 需要自己手动触发
        // 这里是捕获不到里面 抛出来的异常的, 因为不在同一个线程里面
        System.out.println("===== cyf ==== controller当前线程: " + Thread.currentThread().getName());
        return transactionService.testRollBack();
    }
}
