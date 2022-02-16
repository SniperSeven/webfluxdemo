package com.sniper.webflux.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
//@EnableTransactionManagement 手动编程方式不需要
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }
}
