package com.sniper.webflux.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义加密器 可以用非对称加密来做
 *
 * @author Chengyafeng
 * @date 2022/02/13 20:19
 **/
@Component
public class MyEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + rawPassword);
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + encodedPassword);
        return (rawPassword.toString()).equals(encodedPassword);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return PasswordEncoder.super.upgradeEncoding(encodedPassword);
    }
}
