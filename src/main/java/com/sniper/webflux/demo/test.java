package com.sniper.webflux.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Chengyafeng
 * @date 2022/02/13 16:23
 **/
public class test {

    public static void main(String[] args) {
        BCryptPasswordEncoder tt = new BCryptPasswordEncoder();
        String encode = tt.encode("123456");
        System.out.println(encode);

    }
}
